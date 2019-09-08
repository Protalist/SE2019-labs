
import com.mycompany.ws_bank.LoanAccount;
import com.mycompany.ws_bank.Services;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorenzo
 */
public class ClientLezzo {
    public static void main(String[] args) {
        Services s= new Services();
        Map<String,Integer> clientisaldo =s.getDBclientSaldo();
        for(Entry<String,Integer> e: clientisaldo.entrySet()){
            System.out.println("Saldo conto di "+e.getKey()+" : "+e.getValue().toString());
        }
        List<LoanAccount> l;
        
        l = s.getLoaners();
        System.out.println("# prestiti = "+l.size());
        for(LoanAccount x : l){
            System.out.println(x.getTerms());
        }
    }
}
