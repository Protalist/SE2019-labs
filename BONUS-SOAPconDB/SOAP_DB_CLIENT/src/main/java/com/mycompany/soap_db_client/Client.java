/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_db_client;


import com.mycompany.soap_db_server.MAPPA;
import com.mycompany.soap_db_server.SERVICESIFACE;
import com.mycompany.soap_db_server.ServicesImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXB;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import com.mycompany.soap_db_server.MapAdapter;
import java.net.URL;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author lorenzo
 */
public class Client {
    public static void main(String[] args) {
        try {
            QName ServName=new QName("http://soap_db_server.mycompany.com/","ServicesImplService");
            QName PortName= new QName("http://Bank.server_bank.mycompany.com/","ServicesImplPort");
         
            URL wisdol = new URL("http://localhost:7777/ServerAuto?wsdl");   
            Service service = Service.create(wisdol,ServName);
            
           
            SERVICESIFACE ServicesProxy =service.getPort(PortName,SERVICESIFACE.class);
            
         /*  Map<Integer,String> map ;
            MapAdapter ad = new MapAdapter();                                                       FARE UNMARSHAL A MANO!
            map = ad.unmarshal(ServicesProxy.getMapAuto());       */
            
            List<String> autos = ServicesProxy.getAutoInDB();
            for(String s:autos){
                System.out.println(s);
            }/*
            for(Entry<Integer,String> e : map.entrySet()){
                System.out.println("<"+" "+e.getKey()+" "+e.getValue()+">");
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
