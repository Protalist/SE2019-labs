/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend.services;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ListOfItem")
public class ListofItem {
    @XmlElementWrapper(name = "Lista")
    @XmlElement(name = "I")
    private List<Item> allitems = new ArrayList();

    public ListofItem() {
    }

    public List<Item> getItems() {
        return this.allitems;
    }

    public void setItems(List<Item> items) {
        this.allitems = items;
    }
    
}
