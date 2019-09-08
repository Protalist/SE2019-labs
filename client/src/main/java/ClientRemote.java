

import com.mycompany.client.LoanAccount;
import com.mycompany.client.ServicesInterface;
import com.mycompany.ws_bank.BankInterface;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import static support.Utilities.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorenzo
 */
public class ClientRemote {
    public static void main(String[] args) throws MalformedURLException {
       
            QName ServName=new QName("http://ws_bank.mycompany.com/","ServicesService");
            QName PortName= new QName("http://ws_bank.mycompany.com/","ServicesPort");
         
            URL wisdol = new URL("http://localhost:8081/Services?wsdl");   
            Service service = Service.create(wisdol,ServName);
            
           
            
           
                
            ServicesInterface ServicesProxy =service.getPort(PortName,ServicesInterface.class);
            Map<String,Integer> clientisaldo =unmarshalMAP2(ServicesProxy.getDBclientSaldo());
            for(Map.Entry<String,Integer> e: clientisaldo.entrySet()){
                System.out.println("Saldo conto di "+e.getKey()+" : "+e.getValue().toString());
            }
            List<LoanAccount> l;
        
            l = unmarshalLOA(ServicesProxy.getLoaners());
            System.out.println("# prestiti = "+l.size());
            for(LoanAccount x : l){
                System.out.println(x.getTerms());
        }
    }
     
    /*
   
        }*/
    
}
