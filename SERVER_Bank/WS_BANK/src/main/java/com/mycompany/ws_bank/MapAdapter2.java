/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ws_bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
public class MapAdapter2 extends XmlAdapter<MAP2, Map<String, Integer>> {

    @Override
    public Map<String, Integer> unmarshal(MAP2 arg0) throws Exception {
        Map<String,Integer> res = new HashMap<>();
        for(MAP2.MAP2Entry e : arg0.getEntries()){
            res.put(e.getNome(), e.getValue());
        }
        return res;
    }

    @Override
    public MAP2 marshal(Map<String, Integer> arg0) throws Exception {
        MAP2 m = new MAP2();
        for(Entry<String,Integer> e:arg0.entrySet()){
            MAP2.MAP2Entry newentry = new MAP2.MAP2Entry();
            newentry.setNome(e.getKey());
            newentry.setValue(e.getValue());
            m.getEntries().add(newentry);
        }
        return m;
    }
    
}
