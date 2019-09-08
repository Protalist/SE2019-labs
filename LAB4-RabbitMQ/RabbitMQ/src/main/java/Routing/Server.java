//this time the server produces, but a client can choose where to subscribe i.e. which messages wants to receive
package Routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Random;



public class Server implements Severity{
    private static final String EXCHANGE_NAME = "direct_logs";

  public static void main(String[] argv) throws Exception {
      
    Random rand = new Random();
    Level [] l = Level.values();

// Obtain a number between [0 - 49].
    
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");  // this time the exchange is of the type direct: it allows the subscriber to select to receive only messages which severity 
                                                          //  is the same as the severity of the queue they bind
        while(true){
            
            Level selected = l[rand.nextInt(l.length)];
            String severity =  selected.toString();
            String message = "Message of level "+severity;

            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
            Thread.sleep(3000);
        }
    }
  }
    
}
