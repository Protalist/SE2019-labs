/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.server.jsontime;

import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class SpecialNews {
    private String News;
    private int bigValue;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.News);
        hash = 89 * hash + this.bigValue;
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
        final SpecialNews other = (SpecialNews) obj;
        if (this.bigValue != other.bigValue) {
            return false;
        }
        if (!Objects.equals(this.News, other.News)) {
            return false;
        }
        return true;
    }

    public String getNews() {
        return News;
    }

    public void setNews(String News) {
        this.News = News;
    }

    public int getBigValue() {
        return bigValue;
    }

    public void setBigValue(int bigValue) {
        this.bigValue = bigValue;
    }

    @Override
    public String toString() {
        return "SpecialNews{" + "News=" + News + ", bigValue=" + bigValue + '}';
    }
    
    
}
