/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2.client;

import java.time.LocalDate;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Giuli
 */
@XmlRootElement( name = "Risorsa" )
public class Risorsa2 {
    
    private LocalDate foundation;

    
    private String id;
    
    
    private String name;
     
   
    public Risorsa2() {
        this.id = "";
        this.name = "";
        this.foundation=LocalDate.now();
    }

    public String getId() {
        return id;
    }

    @XmlElement(name = "identifier")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    
     public LocalDate getFoundation() {
        return this.foundation;
    }
     
    @XmlElement(name = "anno")
    @XmlJavaTypeAdapter(DateAdapter2.class)
    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Risorsa2 other = (Risorsa2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Risorsa{" + "id=\t" + id + ",\tname=\t" + name + "\tfoundation"+foundation+"/t}";
    }
}
