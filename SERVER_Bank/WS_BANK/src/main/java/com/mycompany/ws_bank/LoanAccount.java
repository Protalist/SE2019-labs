/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author lorenzo
 */
@XmlJavaTypeAdapter(LoanAccountAdapter.class)
public interface LoanAccount {
    public int getID();
    public void setID(int ID);
    public String getTerms();
    public void setTerms(String Terms);
    
    
}
