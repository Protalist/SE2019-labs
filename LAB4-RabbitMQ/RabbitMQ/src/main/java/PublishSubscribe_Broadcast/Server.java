// producer - publisher
// this time we publish and more client can read
// if we sent a message, all subscribe online will read it
package PublishSubscribe_Broadcast;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author lorenzo
 */
public class Server {
    private static final String EXCHANGE_NAME = "logs";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {    
                                                          // In the general case messages are not sent directly to a queue, but they are sent to an exchange.
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); /* An exchange is a very simple thing. On one side it receives messages from producers and the other side it pushes them to queues.
                                                             The exchange must know exactly what to do with a message it receives. Should it be appended to a particular queue? Should it be 
                                                             appended to many queues? Or should it get discarded. The rules for that are defined by the exchange type. 
                                                              fanout is the easiest type of exchange --> it just broadcasts messages to all the queue he knows */
                
        int r = "53212256564156dassd".hashCode()+(int) (Math.random()*100);
        String message = "Message "+r;

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
    }
  }
    
}
