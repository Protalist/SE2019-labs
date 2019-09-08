/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap_db_server;

import com.mycompany.soap_db_server.MAPPA.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class MapAdapter extends XmlAdapter<MAPPA,Map<Integer,String>> {

    @Override
    public Map<Integer, String> unmarshal(MAPPA arg0) throws Exception {
        Map<Integer,String> r = new HashMap<>();
        for(MAPPA.MAPPAEntry m : arg0.getEntries()){
            r.put(m.getKey(), m.getValue());
        }
        return r;
    }

    @Override
    public MAPPA marshal(Map<Integer, String> arg0) throws Exception {
        MAPPA r = new MAPPA();
        for(Entry<Integer,String> e:arg0.entrySet()){
            MAPPA.MAPPAEntry x = new MAPPA.MAPPAEntry();
            
            x.setKey(e.getKey());
            x.setValue(e.getValue());
            r.getEntries().add(x);
        }
        return r;
    }

    
}
