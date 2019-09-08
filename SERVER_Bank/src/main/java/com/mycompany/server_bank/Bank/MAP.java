/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.util.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */
 @XmlType(name = "MAP")
public class MAP {
    private List<MAPEntry> entries = new ArrayList<MAPEntry>();
 
    @XmlElement(nillable = false, name = "entry")
    public List<MAPEntry> getEntries() {
        return entries;
    }
 
    @XmlType(name = "MAPEntry")
    public static class MAPEntry {
        private Integer id;
        private String value;

        public void setId(Integer id) {
            this.id = id;
        }

        public void setValue(String value) {
            this.value = value;
        }
 
        // getters and setters

        public Integer getId() {
            return id;
        }

        public String getValue() {
            return value;
        }
    }
}
