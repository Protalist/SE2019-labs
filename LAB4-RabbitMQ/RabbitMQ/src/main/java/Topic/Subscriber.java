
package Topic;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.util.Random;
/**
 *
 * @author lorenzo
 */
public class Subscriber {
    private static final String EXCHANGE_NAME = "topic_logs";
    
    public static void main(String[] argv) throws Exception {
    Random rand = new Random();
    String [] listaPossibleBindings={"*","#","it.sport","it.documentary","it.*","de.*","it.news","*.sport","esp.news","fr.#"};  // these are the bind keys that a subscriber can choose
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "topic");
    String queueName = channel.queueDeclare().getQueue();

   

    String bindingKey =listaPossibleBindings[rand.nextInt(listaPossibleBindings.length)];
    channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
    

    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println(" [x] Received '" +
            delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
    };
    channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
  }
}
