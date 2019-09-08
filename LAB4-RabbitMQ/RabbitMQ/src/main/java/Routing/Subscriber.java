//This time subscriber will receive only the message that have a CHOSEN severity 
package Routing;
import com.rabbitmq.client.*;
import java.util.Random;

public class Subscriber implements Severity {
    private static final String EXCHANGE_NAME = "direct_logs";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
    String queueName = channel.queueDeclare().getQueue();

  
    Random rand = new Random();
    Level [] l = Level.values();
    
    channel.queueBind(queueName, EXCHANGE_NAME,l[rand.nextInt(l.length)].toString() );  //here the queue is binded to the level of severity chosen
  
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" +
            delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
    };
    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
  }
}
    

