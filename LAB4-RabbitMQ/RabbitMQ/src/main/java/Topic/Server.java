//publisher

package Topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.Random;
public class Server implements RoutingKeys{
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Random rand = new Random();
    Routinkeys []list = Routinkeys.values();
    domains[]listDomain = domains.values();
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {

        channel.exchangeDeclare(EXCHANGE_NAME, "topic"); // this time the exchange is of topic type
                                                         /* topics must have a routing key  in the form "it.stock.market" . Each routing key identifies the queue for the topic
                                                             Each message is sent to a queue identified by a routing key*/
                                                         
                                                         
        String message,routingKey,tmpKey,tmpDomain;    
        
        while(true){
            tmpKey = list[rand.nextInt(list.length)].toString();
            tmpDomain = listDomain[rand.nextInt(listDomain.length)].toString();
            routingKey = tmpDomain+"."+tmpKey;
            message = "Message about "+tmpKey+" from "+tmpDomain;
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
            Thread.sleep(3000);
         }
    }
  }
}
