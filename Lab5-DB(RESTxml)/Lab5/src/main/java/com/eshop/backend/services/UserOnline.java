/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend.services;

import java.util.Objects;

/**
 *
 * @author lorenzo
 */
public class UserOnline {
    int id;

    @Override
    public String toString() {
        return "UserOnline{" + "id=" + id + ", nome=" + nome + '}';
    }
    String nome;
    

    public UserOnline(int id, String nome) {
        this.id = id;
        this.nome = nome;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nome);
       
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
        final UserOnline other = (UserOnline) obj;
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    

    
    
}
