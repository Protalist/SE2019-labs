/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */

@XmlType(name = "ListofAccount")
public class ListofAccount {
    private List<LoanAccount> loanAccounts = new ArrayList<>();
    @XmlElement(nillable = false, name = "loanaccount")
    public List<LoanAccount> getLoanAccounts(){
        return this.loanAccounts;
    }
    
}
