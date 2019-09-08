/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author lorenzo
 */
@XmlJavaTypeAdapter(ContoAdapter.class)
public interface Conto {
    public int getID();
    public int getSaldo();
    
    public void setID(int ID);
    public void setSaldo(int ID);
}
