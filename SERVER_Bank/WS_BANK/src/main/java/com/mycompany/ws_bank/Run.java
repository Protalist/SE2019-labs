/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;


/**
 *
 * @author lorenzo
 */
public abstract class Run {
   
        public static void main(String[] args) {
        
            
            /*String [] operations ;
         
            String[] cids= (String[]) i.getClientIDs();
            for(String c:cids){
            
                operations=i.getOperationsByClientID(new Integer(c));
                for(String prn:operations){
                    System.out.println(prn);
             }
                tring datiClient = i.getClientByID(new Integer(c));
                System.out.println(datiClient);
            }
                
            Map<Integer,String> DB = i.getDbop();
            for(Entry<Integer,String> e:DB.entrySet()){
                System.out.println("[ "+e.getValue()+"  -  "+e.getKey()+" ]");
            }
            */
             //dosomething();
            Services implementor = new Services();
            
            String address = "http://localhost:8081/Services";
            System.out.println("http://localhost:8081/Services?wsdl");
            Endpoint.publish(address, implementor);
            
           
            while(true);
        }
        
        private static void dosomething(){
            try {
            QName ServName=new QName("http://Bank.server_bank.mycompany.com/","BankImplementationService");
            QName PortName= new QName("http://Bank.server_bank.mycompany.com/","BankImplementationPort");
         
            URL wisdol = new URL("http://localhost:9080/Server?wsdl");   
            Service service = Service.create(wisdol,ServName);
            
           
                
            BankInterface ServicesProxy =service.getPort(PortName,BankInterface.class);
            ServicesProxy.getConti();

            
       }catch(Exception e){
                System.out.println(e.getMessage());}
 
    
            
        }
        
}

