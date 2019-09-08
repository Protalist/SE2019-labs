/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */
@XmlType(name = "LoanAccount")
public class LoanAccountImpl implements LoanAccount {
    private int ID;
    private String Terms;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTerms() {
        return Terms;
    }

    public void setTerms(String Terms) {
        this.Terms = Terms;
    }

    public LoanAccountImpl(int ID, String Terms) {
        this.ID = ID;
        this.Terms = Terms;
    }

    

    
    
}
