/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */
@XmlType(name = "SET")
public class SET {
    private List<Conto>  entries =new LinkedList<Conto>();
    @XmlElement(nillable = false, name = "entry")
    public List<Conto> getEntries() {
        return this.entries;
    }
    
}
