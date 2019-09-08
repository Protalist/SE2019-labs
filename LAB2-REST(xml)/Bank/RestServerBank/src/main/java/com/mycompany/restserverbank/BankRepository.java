/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverbank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author lorenzo
 */
@Path("bank")
@Produces("text/xml")
public class BankRepository {
    private ListofConto contiX = new ListofConto();
    private Map<Integer,String> DBop = new HashMap<>();
    
    public BankRepository(){
        LinkedList<Conto> conti = new LinkedList<>();
        Conto c1 = new Conto();
        c1.setId(1);c1.setName("Aldo Spaccautto");c1.setSaldo(2000000000);
        Conto c2 = new Conto();
        c2.setId(2);c2.setName("Pippo Lottao");c2.setSaldo(3036);
        Conto c3 = new Conto();
        c3.setId(3);c3.setName("Franco Pesciolino");c3.setSaldo(7500);
        conti.add(c1);conti.add(c2);conti.add(c3);
        contiX.setConti(conti);
        
        DBop.put(133,"[103,1,11/02/2018,acquistiWeb,89$]");
        DBop.put(22,"[102,1,10/09/2017,Bonifico,31$]");
        DBop.put(15,"[105,3,13/08/2019,acquistiNegozio,565$]");
        DBop.put(16,"[106,2,30/07/2019,pagamento,99$]");
        DBop.put(17,"[107,2,9/08/2019,acquistiWeb,24$]");
        DBop.put(18,"[108,3,2/04/2019,cena,125$]");
    }

    public ListofConto getConti() {
        return contiX;
    }

    public void setConti(ListofConto conti) {
        this.contiX = conti;
    }

    public Map<Integer, String> getDBop() {
        return DBop;
    }

    public void setDBop(Map<Integer, String> DBop) {
        this.DBop = DBop;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.contiX);
        hash = 97 * hash + Objects.hashCode(this.DBop);
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
        final BankRepository other = (BankRepository) obj;
        if (!Objects.equals(this.contiX, other.contiX)) {
            return false;
        }
        if (!Objects.equals(this.DBop, other.DBop)) {
            return false;
        }
        return true;
    }
    //REST Services
    
    @GET
    @Path("transaction/{transID}")
    public String getTransactionById(@PathParam("transID") int transID){
        if (DBop.containsKey(transID)){
            return DBop.get(transID);
        }
        return "Not found";
                
        
    }
    
    
    
    @GET
    @Path("conto/getconti")
    public ListofConto getallconti(){
        return this.getConti();
        
    }
    
    @POST
    @Path("transaction/new/{transazione}/{idConto}")
    public Response newTransaction(@PathParam("transazione")String transazione,@PathParam("idConto")int idConto){
        if(contiX.getConti().contains(idConto)){
            DBop.put(idConto, transazione);
            String []tmp = transazione.split(",");
            String money = tmp[tmp.length-1];
            int mn =  new Integer(money.substring(0, money.length()-2));
            
            for(Conto c:contiX.getConti()){
                if(c.getId() == idConto){
                    c.setSaldo(c.getSaldo() - mn);
                }
                       
            }
            return Response.ok().build();
        }
        return Response.notModified().build();
        
    }
    
}
