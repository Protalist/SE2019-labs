/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverbank;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorenzo
 */
@XmlRootElement(name = "ListOfConto")
public class ListofConto {
    @XmlElementWrapper(name = "Lista")
    @XmlElement(name = "Conto")
    private List<Conto> allconti;

    public List<Conto> getConti() {
        return this.allconti;
    }

    public void setConti(List<Conto> conti) {
        this.allconti = conti;
    }
    
    
}
