

package com.mycompany.soap_db_server;

import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author lorenzo
 */

@XmlType(name="MAPPA")
public class MAPPA {
    
    private List<MAPPAEntry> entries = new ArrayList<>();
    
    @XmlElement(nillable = false, name = "entry")
    public List<MAPPAEntry> getEntries() {
        return entries;
    }

    
    
    
    @XmlType(name = "MAPPAEntry")
    public static class MAPPAEntry{
        private int key;
        private String value;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
    }
}
