/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2.client;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Giuli
 */
public class DateAdapter2 extends XmlAdapter<String, LocalDate>{
     @Override
    public LocalDate unmarshal( String date ) throws Exception
    {
        return LocalDate.parse(date);
    }
    
    @Override
    public String marshal( LocalDate date ) throws Exception
    {
        return "string"+date.toString();
    }
}
