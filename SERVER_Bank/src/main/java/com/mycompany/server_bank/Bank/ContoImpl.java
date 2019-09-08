/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */
@XmlType(name = "Conto")
public class ContoImpl implements Conto{
    private int ID;
    private int Saldo;

    public ContoImpl(int ID, int Saldo) {
        this.ID = ID;
        this.Saldo = Saldo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }
    

  
    public int getID() {
        return this.ID;
    }

   
    public int getSaldo() {
        return this.Saldo;
    }
    
}
