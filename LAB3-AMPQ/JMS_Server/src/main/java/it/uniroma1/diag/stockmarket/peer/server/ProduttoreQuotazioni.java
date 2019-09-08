package it.uniroma1.diag.stockmarket.peer.server;

import javax.jms.*;
import javax.naming.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProduttoreQuotazioni implements MessageListener{
	final String titoli[] = { "Telecom", "Finmeccanica", "Banca_Intesa",
			"Oracle", "Parmalat", "Mondadori", "Vodafone", "Barilla" };
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        TopicSession session = null;
        Destination destination = null;
        MessageProducer producer = null;
        String destinationName = "dynamicTopics/Quotazioni";
        double numero = 5;
        

	private String scegliTitolo() {
		int whichMsg;
		Random randomGen = new Random();

		whichMsg = randomGen.nextInt(this.titoli.length);
		return this.titoli[whichMsg];
	}

	private float valore() {
		Random randomGen = new Random();
		float val = randomGen.nextFloat() * this.titoli.length * 10;
		return val;
	}

        private static final Logger LOG = LoggerFactory.getLogger(ProduttoreQuotazioni.class);
        
	public void start() throws NamingException, JMSException {
                
                
                /*
         * Create a JNDI API InitialContext object
         */
        
        try {
            
            Properties props = new Properties();
        
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(props);        
                
        } catch (NamingException e) {
            LOG.info("ERROR in JNDI: " + e.toString());
            System.exit(1);
        }

        /*
         * Look up connection factory and destination.
         */
        try {
            connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            destination = (Destination)jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            LOG.info("JNDI API lookup failed: " + e);
            System.exit(1);
        }

        /*
         * Create connection. Create session from connection; false means
         * session is not transacted. Create sender and text message. Send
         * messages, varying text slightly. Send end-of-messages message.
         * Finally, close connection.
         */
        try {
            connection = connectionFactory.createConnection();
            session = (TopicSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);  // consegna garantita pure se listener inattivo
            
            TopicSubscriber subscriber= this.session.createSubscriber((Topic) this.destination, null, true);  // per far funzionare il listener serve il subscribe al topic!
            connection.start();
            subscriber.setMessageListener(this);
              
                
                TextMessage message = null;
		String messageType = null;
		
                message = session.createTextMessage();

                float quotazione;
		int i = 0;
                double s;
		while (true) {
                        
			i++;
                        s=this.numero;
			messageType = scegliTitolo();
			quotazione = valore();
			message.setStringProperty("Nome", messageType);
			message.setFloatProperty("Valore", quotazione);
			message.setText(
					"Item " + i + ": " + messageType + ", Valore: "
					+ quotazione);

			    LOG.info(
					this.getClass().getName() + 
				        "Invio quotazione: " + message.getText()+" "+s);

			producer.send(message);

			try {
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
        
        catch (JMSException e) {
            LOG.info("Exception occurred: " + e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
    }
    
    @Override
    public void onMessage(Message arg0) {
            try {
                System.out.println("Num arrivato");
                System.out.println(arg0.getDoubleProperty("Num"));
                numero = arg0.getDoubleProperty("Num");
            } catch (JMSException ex) {
                java.util.logging.Logger.getLogger(ProduttoreQuotazioni.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}