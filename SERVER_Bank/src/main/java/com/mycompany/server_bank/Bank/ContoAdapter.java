/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
public class ContoAdapter extends XmlAdapter<ContoImpl, Conto> {

    
    public Conto unmarshal(ContoImpl arg0) throws Exception {
        return arg0;
    }
    
    public ContoImpl marshal(Conto arg0) throws Exception {
        if(arg0 instanceof ContoImpl){
            return (ContoImpl) arg0;
        }
        return new ContoImpl(arg0.getID(),arg0.getSaldo());
    }
    
    
}
