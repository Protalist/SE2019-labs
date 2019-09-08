/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.util.Map;
import java.util.Set;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author lorenzo
 */
@WebService
public interface BankInterface {
   
    public String[] getOperationsByClientID(int ClientId);
 
    public String getOperationByID(int opID);
    
    public String[] getClientIDs();
    
    public String getClientByID(int clientID);
    
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<Integer,String> getDbop();
    
    
    @XmlJavaTypeAdapter(SetAdapter.class)
    public Set<Conto> getConti();
    
 
}
    

