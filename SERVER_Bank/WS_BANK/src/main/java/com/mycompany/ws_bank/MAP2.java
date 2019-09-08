/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */
@XmlType(name ="MAP2") 
public class MAP2 {
    private List<MAP2Entry> entries= new LinkedList<>();
    
    @XmlElement(nillable = false, name = "entry")
    public List<MAP2Entry> getEntries() {
        return entries;
    }
 
    @XmlType(name = "MAP2Entry")
    public static class MAP2Entry {
        private String nome;
        private int value;

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setValue(int value) {
            this.value = value;
        }
 
        // getters and setters

        public String getNome() {
            return nome;
        }

        public int getValue() {
            return value;
        }
    }
    
}
