/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author lorenzo
 */
@WebService
public interface ServicesInterface {
    @XmlJavaTypeAdapter(MapAdapter2.class)
    public Map<String,Integer> getDBclientSaldo();  // map  key = Nome Cognome       value  = Saldo
    
    @XmlJavaTypeAdapter(ListofAccountsAdapter.class)
    public List<LoanAccount> getLoaners();
    
}
