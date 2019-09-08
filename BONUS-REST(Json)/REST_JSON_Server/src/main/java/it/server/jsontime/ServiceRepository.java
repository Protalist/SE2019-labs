/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.server.jsontime;

import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lorenzo
 */

@Path("news")
@Produces({MediaType.APPLICATION_JSON})
public class ServiceRepository {
    private NewsList nl = new NewsList();
    
    @GET
    @Path("/newStuff")
    public String sendNuwes(){
        Random x = new Random();
        int a = x.nextInt(100);
        if(a<=20){
            return "UGANDA - MANGIA UN SASSO E MUORE";
        }
        else if(a>20 && a<=40){
            return "USA - SPARATORIA IN UN MCDONALD, UCCISI DEI CICCIONI";
        }
        else if(a>40 && a<=60){
            return "NAPOLI - ARRESTATO POLIZIOTTO DALLA CAMMORRA";
        }
        else if(a>60 && a<=80){
            return "POFI - SIMONE HA TENDENZE OMOSESSUALI";
        }
        else{
            return "CASILINA VECCHIA - IL VILE DICHIARA GUERRA A CHAD PER IL CONTROLLO DELLE VICINE";
        }
        
    }
    
    @GET
    @Path("/specialNews/{numero}")
    public SpecialNews sendSpecialNuwes(@PathParam("numero")int numero){
        Random x = new Random();
        if(numero <=0){
            numero =20;
        }
        int a = x.nextInt(numero)*1000;
        SpecialNews r = new SpecialNews();
        r.setBigValue(a);
        if(a%2 == 0){
            r.setNews("FROSINONE - IL MAESTRO EGEO MINOTTI PROCLAMATO SANTO");
            
        }
        else{
            r.setNews("TFT - PROCLAMATI ILLEGALI I RANGER COI FANTASMI, IL VILE NON CI STA");
        }
        return r;
    }
    
    @POST
    @Path("/postaSpecialNews/{news}/{num}")
    public Response postaSpecialNews(@PathParam("news")String news,@PathParam("num") int N){
        System.out.println("arrivata news");
        System.out.println(news);
        SpecialNews n = new SpecialNews(); 
        n.setNews(news.replace("_", " "));
        n.setBigValue(N);
        nl.getList().add(n);
        return Response.ok().build();
    }
    
    @GET
    @Path("/sendaNewsList")
    public NewsList sendaNewsList(){
        if(this.nl.getList().size()>0){
            return this.nl;
        }
        else{
            NewsList ll =new NewsList();
            SpecialNews l = new SpecialNews(); l.setNews("AGGIUNGI ROBA DEFICIE");l.setBigValue(999);
            ll.addNews(l);
            return ll;
        }
    }
    
    
}
