/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.stockmarket.client;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

/**
 *
 * @author lorenzo
 */
public class ClientJMS implements MessageListener{
    private  void getAzioniRispettose(double valMin,double valMax){  // CLIENT AS SUBSCRIBER HERE
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        TopicSession session = null;
        Destination destination = null;
       
        String destinationName = "dynamicTopics/Quotazioni";
        
        try {
            
            Properties props = new Properties();
        
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(props);        
                
        } catch (NamingException e) {
            
            System.exit(1);
        }
        
        try {
            connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            destination = (Destination)jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            
            System.exit(1);
        }
        try {
            connection = connectionFactory.createConnection();
            session = (TopicSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
     
            
            TopicSubscriber subscriber= session.createSubscriber((Topic) destination, "Valore >="+valMin+" AND Valore <="+valMax, true); // opzioni per selezionare i messaggi da ricevere
            connection.start();
            subscriber.setMessageListener(this);
              
                
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);}
    }
    
    private  void getEsitoOfferta(){  // CLIENT AS SUBSCRIBER HERE
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        TopicSession session = null;
        Destination destination = null;
       
        String destinationName = "dynamicTopics/Ordini";
        
        try {
            
            Properties props = new Properties();
        
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            jndiContext = new InitialContext(props);        
                
        } catch (NamingException e) {
            
            System.exit(1);
        }
        
        try {
            connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
            destination = (Destination)jndiContext.lookup(destinationName);
        } catch (NamingException e) {
            
            System.exit(1);
        }
        try {
            connection = connectionFactory.createConnection();
            session = (TopicSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
     
            
            TopicSubscriber subscriber= session.createSubscriber((Topic) destination,null, true); 
            connection.start();
            subscriber.setMessageListener(this);
              
                
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(1);}
    }
    
    private void sendOffer(String s) throws JMSException, NamingException{  //CLIENT AS PUBLISHER HERE
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Topic destination = null;
        String destinationName = "dynamicTopics/Ordini";

        /*
* Create a JNDI API InitialContext object
         */
        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        jndiContext = new InitialContext(props);

        connectionFactory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
        destination = (Topic) jndiContext.lookup(destinationName);

        connection = (Connection) connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageProducer prod = session.createProducer(destination);
        Message M;
        M = session.createTextMessage();
        
        String User = s;
        String Input = JOptionPane.showInputDialog("CIAO "+User+"\n Dimmi Nome-prezzo-quantita dell'azione che vuoi comprare (nome-prezzo-quantita)");
        String[] arr=Input.split("-");
        
       
        M.setStringProperty("Utente", User);
        M.setStringProperty("Nome", arr[0]);
        M.setFloatProperty("Prezzo", new Float(arr[1]));
        M.setIntProperty("Quantita", new Integer(arr[2]));
        
        //M.setDoubleProperty("Num", 13.5);

        prod.send(M);
        prod.close();
        session.close();
        connection.close();
        System.out.println("FIN");
    }
    

    public static void main(String[] args) throws NamingException, JMSException,InterruptedException {
        ClientJMS c = new ClientJMS();
        String User =JOptionPane.showInputDialog("Benvenuto! Inserisi il tuo username");
        String Number = JOptionPane.showInputDialog("Inserisci i VALORI che vuoi ricevere (scrivi valMin-valMax)");
        String[] ns =Number.split("-");
        int valMin = new Integer(ns[0]);int valMax = new Integer(ns[1]);
        int i = 0;
        c.getAzioniRispettose(new Double(valMin),new Double(valMax));
        c.getEsitoOfferta();
        while(true){
            
            Thread.sleep(1000);
            if(i!=0 && i%20==0){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Senda l'offerta?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    c.sendOffer(User);
                }
            }
            i++;
        }
        
        
    }

    @Override
    public void onMessage(Message arg0) {
        TextMessage m = (TextMessage) arg0;
        String s = "";
        
        try {
            if (m.propertyExists("Status")){
                s+=m.getStringProperty("Utente")+"\n";
                s+=m.getStringProperty("Nome")+"\n";
                s+=m.getBooleanProperty("Status")+"\n";
                s+=m.getIntProperty("Quantita")+"\n";
                s+=m.getFloatProperty("Prezzo")+"\n";
                System.out.println(s);
            }
            else if (m.propertyExists("Valore")){
            s+=m.getStringProperty("Nome");
            s+=" VALORE = "+m.getDoubleProperty("Valore");
            System.out.println(s);
            }
        } catch (JMSException ex) {
            Logger.getLogger(ClientJMS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
