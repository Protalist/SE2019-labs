/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.util.Set;
import java.util.HashSet;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
public class SetAdapter extends XmlAdapter<SET,Set<Conto>>{

    @Override
    public Set<Conto> unmarshal(SET arg0) throws Exception {
        Set<Conto> res=new HashSet<Conto>();
        for(Conto c:arg0.getEntries()){
            res.add(c);
        }
        return res;
    }

    @Override
    public SET marshal(Set<Conto> arg0) throws Exception {
        SET res = new SET();
        for(Conto c:arg0){
            res.getEntries().add(c);
        }
        return res;
    }

    
}
