/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_db_server;


import com.mycompany.DB.DB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author lorenzo
 */

@WebService(endpointInterface ="com.mycompany.soap_db_server.SERVICESIFACE")
public class ServicesImpl implements SERVICESIFACE{


    public String[] getAutoInDB() {
        List<String> dbAuto = DB.selectAllAuto();
        String [] r = new String [dbAuto.size()];
        int i=0;
        for(String s:dbAuto){
            r[i++]=s;
        }
        return r;
    }

    
    @XmlJavaTypeAdapter(MapAdapter.class)
    public Map<Integer, String> getMapAuto() {
        List<String> dbAuto = DB.selectAllAuto();
        Map<Integer,String> mappa = new HashMap<>();
        String res="";int hp=0;
        for(String s:dbAuto){
            hp = new Integer(s.split(",")[2].replace("\n", ""));
            res = s.split(",")[0];
            mappa.put(hp, res);
        }
        return mappa;
        
    }
    
}
