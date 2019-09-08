/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import com.mycompany.server_bank.Bank.BankImplementation;
import com.mycompany.server_bank.Bank.Conto;
import com.mycompany.server_bank.Bank.ContoImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 *
 * @author lorenzo
 */

@WebService(endpointInterface ="com.mycompany.ws_bank.ServicesInterface")
public class Services implements ServicesInterface{
     BankInterface i ;
    
    private static BankInterface askServer(){
     try {
           QName ServName=new QName("http://Bank.server_bank.mycompany.com/","BankImplementationService");
           QName PortName= new QName("http://Bank.server_bank.mycompany.com/","BankImplementationPort");
         
            URL wisdol = new URL("http://localhost:9080/Server?wsdl");   
            Service service = Service.create(wisdol,ServName);
            
           
                
            BankInterface ServicesProxy =service.getPort(PortName,BankInterface.class);
          
            return ServicesProxy;
       }catch(Exception e){
          System.out.println(e.getLocalizedMessage());}
      return null;
    }

    
    
    List<LoanAccount> loaners =new ArrayList<>();
    
    private void initLoans(){
        LoanAccount l1 = new LoanAccountImpl(500,"Gianni Rossi,1000$");
        LoanAccount l2 = new LoanAccountImpl(501,"Pino Verde,810$");
        LoanAccount l3 = new LoanAccountImpl(502,"Cosetta Nebra,9720$");
        loaners.add(l1);loaners.add(l2);
        loaners.add(l3);
        
    }
    
    private String formatStringNome(String cData)
    {
        String res ="" ;
        boolean comma = true;
        for(char at:cData.toCharArray()){
           if(at =='['){
               continue;
           }
           else if(at == ',' && comma){
               comma = false;
               res+=" ";
           }
           else if(at == ','&& comma == false){
               break;
           }
           else{
               res+=""+at;
           }
        }
        return res;
    } 
    
    public Map<String, Integer> getDBclientSaldo() {
        System.out.println("Richiesta ARRIVATA");
        Map<String,Integer> result= new HashMap<>();
       i =askServer();
        System.out.println("inizialiazzata interfaccia con server");
       List<String> IDs = i.getClientIDs();
        SET Conti = i.getConti();
        System.out.println("QUA1");
       String clientData,nome;
       int IDClient,ii = 0;
       for(;ii<IDs.size();ii++){
            IDClient= new Integer(IDs.get(ii));
            clientData = i.getClientByID(IDClient);
           
            nome = formatStringNome(clientData);
            
            for(com.mycompany.ws_bank.Conto c : Conti.getEntry()){
                if(c.getID()==IDClient){
                  result.put(nome,c.getSaldo());
                  break;
                }
            }
            
       }
        System.out.println("RESULT "+result.size());
       return result;
        
    }

   
    public List<LoanAccount> getLoaners() {
        this.initLoans();
        return loaners;
    }
    
    
}
