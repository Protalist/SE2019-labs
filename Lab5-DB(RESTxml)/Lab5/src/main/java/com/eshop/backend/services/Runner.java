/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend.services;

import com.eshop.backend.BackEnd;
import javax.swing.JOptionPane;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author lorenzo
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        
        factoryBean.setResourceClasses(ShopRepository.class);
        factoryBean.setResourceProvider(
            new SingletonResourceProvider(new ShopRepository()));
        factoryBean.setAddress("http://localhost:8080/");
        
        Server server = (Server) factoryBean.create();
        while(true){
            ShopRepository.printUsersOn();
            String in="";
            in+= JOptionPane.showInputDialog("Inserisci un nuovo item [I = name-type-price] [no]");
            if(in.equals("no")||in==null||in.equals("")||!in.contains("-")||!in.contains("I = ")){}
            else{
                String item = in.substring(3);
                BackEnd.insertItem( "Item", item.replace("-", ","));
                new RabbitMqServer(item,"NEWITEM").run();
            }
            Thread.sleep(30000);
        }
    }
}
