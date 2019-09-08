/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverbank;

import java.util.Objects;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorenzo
 */
@XmlRootElement(name = "Conto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Conto {
    private int id;
    private String Name;
    private int saldo;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.Name);
        hash = 29 * hash + this.saldo;
        return hash;
    }

    @Override
    public String toString() {
        return "Conto di " + Name + ", saldo=" + saldo + "ID"+id+'}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conto other = (Conto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.saldo != other.saldo) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    //Rest SERVICES
    
    
    
    
    
    
}
