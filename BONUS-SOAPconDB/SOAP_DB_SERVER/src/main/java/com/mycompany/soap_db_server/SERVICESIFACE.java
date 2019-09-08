/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_db_server;

import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author lorenzo
 */
@WebService
public interface SERVICESIFACE {
    
    public String[] getAutoInDB(); 
    
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<Integer,String> getMapAuto();
    
}
