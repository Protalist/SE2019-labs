/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
public class ListofAccountsAdapter extends XmlAdapter<ListofAccount,List<LoanAccount>>{

    @Override
    public List<LoanAccount> unmarshal(ListofAccount arg0) throws Exception {
        List<LoanAccount> res = new ArrayList<LoanAccount>();
        for(LoanAccount l:arg0.getLoanAccounts()){
            res.add(l);
        }
        return res;
    }

    @Override
    public ListofAccount marshal(List<LoanAccount> arg0) throws Exception {
        ListofAccount x = new ListofAccount();
       
        for(LoanAccount l :arg0){
            x.getLoanAccounts().add(l);
        }
        return x;
    }

   
    
}
