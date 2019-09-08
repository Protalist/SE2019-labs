/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
public class LoanAccountAdapter extends XmlAdapter<LoanAccountImpl,LoanAccount> {

    @Override
    public LoanAccount unmarshal(LoanAccountImpl arg0) throws Exception {
        
        return arg0;
    }

    @Override
    public LoanAccountImpl marshal(LoanAccount arg0) throws Exception {
         if(arg0 instanceof LoanAccountImpl){
             return (LoanAccountImpl)arg0;
         }
         return new LoanAccountImpl(arg0.getID(),arg0.getTerms());
    }
    
}
