/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server_bank.Bank;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *
 * @author lorenzo
 */

@WebService(endpointInterface ="com.mycompany.server_bank.Bank.BankInterface")
public class BankImplementation implements BankInterface{
    Map<Integer,String> DBop = new HashMap<Integer,String>();  //KEY = opID     String = "[opID,clientID,data,type,money]"
    Map DBclient =new HashMap<Integer,String>(); // KEY = clientID   String = "[Nome,Cognome,dataDiNascita]"
    Set<Conto> conti= new HashSet<Conto>();
    
    public BankImplementation(){
        DBop.put(11,"[11,9,11/02/2018,acquistiWeb,89$]");
        DBop.put(12,"[12,22,10/09/2017,Bonifico,31$]");
        DBop.put(15,"[15,33,13/08/2019,acquistiNegozio,565$]");
        DBop.put(16,"[16,9,30/07/2019,pagamento,99$]");
        DBop.put(17,"[17,22,9/08/2019,acquistiWeb,24$]");
        DBop.put(18,"[18,78,2/04/2019,cena,125$]");
        
        DBclient.put(9,"[Gino,Del Coso,5/04/1998]");
        DBclient.put(22,"[Baolo,Poggeroni,18/11/1993]");
        DBclient.put(33,"[Jesus,Bonobo,3/07/1933]");
        DBclient.put(78,"[Pippo,Frenco,8/05/1979]");
        
        conti.add(new ContoImpl(9,35000));
        conti.add(new ContoImpl(22,100000));
        conti.add(new ContoImpl(33,8100));
        conti.add(new ContoImpl(78,8965000));
        
    
    }
    
    private boolean checkData(int numdays,String data){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
     
        String DATA = formatter.format(date);
        String[] d1 = DATA.split("/");
        String [] d2 = data.split("/");

        if(!d1[0].equals(d2[2])){
           
            return false;
        }
        else {
            int MonthDiff = new Integer(d1[1]) - new Integer(d2[1]);
            if (MonthDiff !=1 && MonthDiff!=0){
               
                return false;
            }
            else{
                int DayDiff = new Integer(d1[2]) - new Integer(d2[0]);
                if(DayDiff>0 ){
                    
                    if (DayDiff<=numdays){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    switch(d2[1]){
                        case "1":
                        case"3":
                        case "5":
                        case "7":
                        case "8":
                        case "10":
                        case "12": 
                            int modData=DayDiff +31;
                            
                            if((modData-new Integer(d1[0]))>numdays) return false;
                            else return true;
                        case "2":   
                           int modData2=DayDiff +28;
                            
                           if((modData2-new Integer(d1[0]))>numdays) return false;
                           else return true; 
                        default:
                             
                           int modData3=DayDiff +30;
                            
                           if((modData3-new Integer(d1[0]))>numdays) return false;
                           else return true;   
                    }
                    
                }
            }
        }
    }
    
    public String[] getOperationsByClientID(int ClientID) {
       
        int numDays = 17; //Consideriamo solo le operazione degli ultimi 15 giorni
        String[] tmp;
        ArrayList<String> r = new ArrayList<>();
        for(Entry<Integer,String> e:DBop.entrySet()){
            tmp=e.getValue().split(",");
            
            if(tmp[1].equals(""+ClientID) && checkData(numDays,tmp[2])){
                r.add(DBop.get(e.getKey()));
            }
            
        }
        String [] res = new String[r.size()];
        int ind=0;
        for(String s:r){
            res[ind++]=s;
        }
        return res;
    }

  
    public String getOperationByID(int opID) {
        return DBop.get(opID);
    }
    
    public String[] getClientIDs(){
        ArrayList<String> r = new ArrayList<>();
        for(Integer i:(Set<Integer>)DBclient.keySet()){
            r.add(""+i);
        }
        String [] res = new String[r.size()];
        int ind=0;
        for(String s:r){
            res[ind++]=s;
        }
        return res;
    }
    
    public String getClientByID(int clientID){
        return (String) DBclient.get(clientID);
    }
    
    public Map<Integer, String> getDbop() {
        return this.DBop;
    }

    @XmlJavaTypeAdapter(SetAdapter.class)
    public Set<Conto> getConti() {
        System.out.println("Richiesta arrivata... mando conti "+conti.size());
        return this.conti;
    }
    
}
