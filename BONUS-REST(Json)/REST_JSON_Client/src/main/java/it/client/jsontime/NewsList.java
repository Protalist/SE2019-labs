/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.client.jsontime;

/**
 *
 * @author lorenzo
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class NewsList {
    private List<SpecialNews> list=new ArrayList<>();

    public List<SpecialNews> getList() {
        return list;
    }

    public void setList(List<SpecialNews> list) {
        this.list = list;
    }
    public void setNews(SpecialNews s){
        this.list.add(s);
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.list);
        return hash;
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
        final NewsList other = (NewsList) obj;
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String r="";
        for(SpecialNews x:list){
            r+=x.toString()+"\n";
        }
        return r;
    }
    
   
}
