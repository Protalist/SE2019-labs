/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import javax.xml.ws.Endpoint;

/**
 *
 * @author lorenzo
 */
public class Server {
int j;
    public static void main(String args[]) throws InterruptedException {
        BankImplementation implementor = new BankImplementation();
        String address = "http://localhost:9080/Server";
        System.out.println("http://localhost:9080/Server?wsdl");
        
        Endpoint.publish(address, implementor);
        while(true);
        
    }
}
