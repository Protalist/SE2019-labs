/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.mycompany.client.ListofAccount;
import com.mycompany.client.LoanAccount;
import com.mycompany.client.MAP2;
import com.mycompany.client.MAP2Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author lorenzo
 */
public class Utilities {
    public static Map<String,Integer> unmarshalMAP2(MAP2 m){
        
        Map<String,Integer> res = new HashMap<>();
        for(MAP2Entry x:m.getEntry()){
            res.put(x.getNome(), x.getValue());
        }
        return res;
    }
    public static List<LoanAccount> unmarshalLOA(ListofAccount l){
        List<LoanAccount> res= new ArrayList<LoanAccount>();
        for(LoanAccount x:l.getLoanaccount()){
            res.add(x);
        }
        return res;
    }
}
