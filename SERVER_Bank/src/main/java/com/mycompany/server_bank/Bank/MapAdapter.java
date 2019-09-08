/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.util.*;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author lorenzo
 */
@XmlType(name = "MapAdapter")
public class MapAdapter extends XmlAdapter<MAP, Map<Integer, String>>  {

    @Override
    public Map<Integer, String> unmarshal(MAP arg0) throws Exception {
        Map<Integer, String> boundMap = new HashMap<Integer, String>();
        for (MAP.MAPEntry Entry : arg0.getEntries()) {
            boundMap.put(Entry.getId(), Entry.getValue());
        }
        return boundMap;
    }

    @Override
    public MAP marshal(Map<Integer, String> arg0) throws Exception {
        MAP valueMap = new MAP();
        for (Map.Entry<Integer, String> boundEntry : arg0.entrySet()) {
            MAP.MAPEntry valueEntry  = new MAP.MAPEntry();
            valueEntry.setValue(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }

    
}
