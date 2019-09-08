/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.backend.services;

/**
 *
 * @author lorenzo
 */
import com.eshop.backend.BackEnd;
import java.time.LocalDate;
import java.util.ArrayList;
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
@Path("shop")
@Produces("text/xml")
public class ShopRepository{
    static List<UserOnline> users =new ArrayList<>();
    
    public static void printUsersOn(){
        if(users.size()==0){System.out.println("No one Online");return;}
        for(UserOnline u:users){
            System.out.println(u.toString()+"\n");
        }
    }
    



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash;
        hash = 97 * hash;
        return hash;
    }

   
    //REST Services
    
    @POST
    @Path("login/{name}/{pwd}")
    public Response login(@PathParam("name") String nome,@PathParam("pwd")String password) throws InterruptedException{
        int id = -1;
        id = BackEnd.selectUserLogin(nome,password);
        if(id>0){
            System.out.println("Login "+nome+" : OK  :)");
            UserOnline u = new UserOnline(id,nome);
            if(!users.contains(u)){
            users.add(u);
            } 
            Thread.sleep(1000);
            return Response.ok().build();
        }
        else{
            System.out.println("Login "+nome+" : KO  :(");
            return Response.notModified().build();
        }
    }
    
    @GET
    @Path("getBasket/{uId}")
    public String getIteminBasket(@PathParam("uId") int id){
        String items=BackEnd.selectBasketofUser(id);
        if(items!=null&&!(items.equals(""))){
            
            return items;
        }
        return null;
    }
    
    @POST
    @Path("/addtoBasket/{uId}/{itemsId}")
    public Response addtoBasket(@PathParam("uId") int id,@PathParam("itemsId")String itemsid){
        String [] items = itemsid.split("-");
        List<Item> i = BackEnd.selectAllItem();
        String todb ="";
        float pricetotal =0;
        for(Item ii:i){
            for(int j = 0;j<items.length;j++){
                if(ii.id==new Integer(items[j])){
                    
                    todb+= "<"+ii.name+" "+ii.type+" "+ii.price+">\n";
                    pricetotal+=ii.price;
                }
            }
        }
        BackEnd.insertBasket("Basket",""+id+","+todb+","+pricetotal);
        return Response.ok().build();
    }
    
    @GET
    @Path("sendId/{name}")
    public String sendId(@PathParam("name")String nome){
        for(UserOnline t:users){
            if(t.nome.equals(nome)){
                return ""+t.id;
            }
        }
        return ""+0;
    }
   
    @POST
    @Path("deleteBasket/{idU}")
    public Response deleteBasket(@PathParam("idU") int idu){
        BackEnd.deleteBasket(idu);
        return Response.ok().build();
    }
    
    @POST
    @Path("/newOrder/{idU}")
    public Response newOrder(@PathParam("idU")int idu){
        String inBasket = BackEnd.selectBasketofUser(idu);
        String [] basket = inBasket.split(" - TOT = ");
         LocalDate myObj = LocalDate.now(); // Create a date object
        BackEnd.insertOrder("Orders", myObj.toString()+","+idu+","+basket[0]+","+basket[1]);
        RabbitMqServer t = new RabbitMqServer(idu,"hai ordinato "+basket[0]+"\n"+"Hai speso "+basket[1],"ORDER");
        t.run();
        return Response.ok().build();
        
    }
    
    @GET
    @Path("/logout/{idu}")
    public Response logout(@PathParam("idu")int id){
        for(UserOnline u:users){
            if(u.id==id){
                users.remove(u);
                return Response.ok().build();
            }
        }
        return Response.notModified().build();
    }
    
    
    @GET
    @Path("showItems")
    public ListofItem showallItems(){
        ListofItem r = new ListofItem();
        List<Item> l = BackEnd.selectAllItem();
        r.setItems(l);
        return r;
    }
    
    
}