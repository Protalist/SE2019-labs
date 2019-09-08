/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend.services;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorenzo
 */
public class RabbitMqServer implements Runnable{
    int idU;
    String mess;
    String type;
    public RabbitMqServer(int i,String m,String type){
        idU=i;
        mess =m;
        this.type=type;

    }
    public RabbitMqServer(String m,String type){
        mess=m;
        this.type=type;
    }

    @Override
    public void run() {
        if(this.type.equals("ORDER")){
            ordernot();
        }
        else if(this.type.equals("NEWITEM")){
            newitemnot();
        }
    }
    
    private void ordernot(){
        ConnectionFactory factory = new ConnectionFactory();
        String QUEUE_NAME = "Order"+idU;
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
         channel.queueDeclare(QUEUE_NAME, false, false, false, null);  // no ack sent by the client in this base case
        String message = "ORDINE EFFETTUATO CON SUCCESSO\n"+mess;
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        } catch (IOException ex) {
            Logger.getLogger(RabbitMqServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(RabbitMqServer.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    private void newitemnot() {
        String EXCHANGE_NAME = "topicExchange";
        ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {

        channel.exchangeDeclare(EXCHANGE_NAME, "topic"); // this time the exchange is of topic type
                                                         /* topics must have a routing key  in the form "it.stock.market" . Each routing key identifies the queue for the topic
                                                             Each message is sent to a queue identified by a routing key*/
                                                         
                                                         
        String message;   
        
     
        message = "NEW ITEM DISPONIBILE!!!!!!!!!!!\n"+mess;
        channel.basicPublish(EXCHANGE_NAME, "new.items", null, message.getBytes("UTF-8"));
    }   catch (IOException ex) {
            Logger.getLogger(RabbitMqServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(RabbitMqServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

