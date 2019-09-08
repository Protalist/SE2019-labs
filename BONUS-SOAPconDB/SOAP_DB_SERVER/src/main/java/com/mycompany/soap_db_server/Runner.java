/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_db_server;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 *
 * @author lorenzo
 */
public class Runner {
    public static void main(String[] args) {
        ServicesImpl implementor = new ServicesImpl();
        String address = "http://localhost:7777/ServerAuto";
        System.out.println("http://localhost:7777/ServerAuto?wsdl");
        
        
      
        Endpoint.publish(address, implementor);
       
        while(true);
    }
    
}
