
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//notifiche per ordini fatti

public class RabbitMqClient implements Runnable {
     private int idc;
     private String type;
    
     public RabbitMqClient(int i,String type){
         idc=i;
         this.type=type;
     }

    @Override
    public void run() {
       if(type.equals("ORDER")){
           ordernot();
           
       }
       else if(type.equals("NEWITEM")){
           newitemnot();
       }
        

     }
    
    private void ordernot(){
        String QUEUE_NAME = "Order"+idc;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try{
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        String message = new String(delivery.getBody(), "UTF-8");
        JOptionPane.showMessageDialog(null, message);
        
         };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        }
        catch(Exception e){};
        
    }
    
    private void newitemnot(){
        String EXCHANGE_NAME = "topicExchange";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
         try {
            connection = factory.newConnection();
             
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, EXCHANGE_NAME,"new.items");
    

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            JOptionPane.showMessageDialog(null, message+"\n RICARICA LA PAGINA PER VEDERLO!");
        };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
         } catch (IOException ex) {
             Logger.getLogger(RabbitMqClient.class.getName()).log(Level.SEVERE, null, ex);
         } catch (TimeoutException ex) {
             Logger.getLogger(RabbitMqClient.class.getName()).log(Level.SEVERE, null, ex);
         }
       

        
    }
 }
    
