//WE SEND differt WORK TO DO (in our case strings) to CLIENTs
// This time we have one queue and multiple workers that want to read it concurrently
package WorkQueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
public class Server {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);    // ack are turned on this time
        int i =6;
        while(i>0){
        
            String message = "MESSAGE # "+i;

            channel.basicPublish("", TASK_QUEUE_NAME,
            MessageProperties.PERSISTENT_TEXT_PLAIN,
            message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
            i--;
        }
    }
  }
    
}
