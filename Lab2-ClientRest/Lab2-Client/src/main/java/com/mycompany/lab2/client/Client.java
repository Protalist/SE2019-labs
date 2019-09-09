/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.*;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Giuli
 */
public class Client {

    private static String BASE_URL = "http://localhost:8080/risorse/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        /*
        XML MESSAGES
         */
        String nomeRisorsa = "hello";
        String geturi = "http://localhost:8080/risorse";
        /*URL url = new URL(geturi + nomeRisorsa);
        InputStream input = url.openStream();
        String r= JAXB.unmarshal(new InputStreamReader(input), String.class);
        System.out.println(r);
        input.close();*/
        WebClient client2 = WebClient.create("http://localhost:8080/risorse/");
        //getResorse(client2);
        //postResosrse(client2);
        //putResorse(client2);
        //deleteResorse(client2);
        postJSONResorse(client2);
        /*
        
        r3.setName("fregna fregna");
        r3.setId("culo");
        */
        
    }
    
    public static void getResorse(WebClient wc){
        /*
         GET
         */

        WebClient client3=wc.path("due");
        Response r = client3.accept("xml").get();
        System.out.println("Status: " + r.getStatus());
        //JAXB.unmarshal( r.getEntity(), Risorsa2.class);
        Risorsa2 r3 = JAXB.unmarshal((InputStream) r.getEntity(), Risorsa2.class);
        //String value = IOUtils.toString((InputStream)r.getEntity());
        //System.out.println("Response from web service is : " + value);
        System.out.println("Risorsa" + r3.toString());
        wc.reset();
    }
    
   public static void postResosrse(WebClient client2) throws IOException{
   
        /*
            POST
         */
        System.out.println(client2.getBaseURI());
        Risorsa2 r3= new Risorsa2();
        r3.setName("Risorsa bella");
        r3.setId("giulio33wqr317676733");
        r3.setFoundation(LocalDate.now());
        //OutputStream xml= new OutputStream();
        File xml = new File("risorsa.txt");
        xml.createNewFile();
        JAXB.marshal(r3, xml);
        BufferedReader br = new BufferedReader(new FileReader(xml));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        System.out.println(client2.getCurrentURI());
        Response r = client2.path("").accept("xml").post(xml);
        
        System.out.println("\n\n\n" +r.getStatus()+"\n"+ r.getHeaders());
        client2.reset();
   }
   
   public static void putResorse(WebClient client2) throws FileNotFoundException, IOException{
        Risorsa2 r3= new Risorsa2();
        r3.setName("Risorsa bella");
        r3.setId("giulio33wqr317676733");
        r3.setFoundation(LocalDate.now());
         File xml = new File("risorsa2.txt");
        JAXB.marshal(r3, xml);
        BufferedReader br = new BufferedReader(new FileReader(xml));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        Response r = client2.path("uno").accept("xml").put(xml);
        
        System.out.println("\n\n\n" +r.getStatus()+"\n"+ r.getHeaders());
        client2.reset();
   }
   
   public static void deleteResorse(WebClient wc) throws FileNotFoundException, IOException{
       WebClient client3=wc.path("giulio");
       Response r = client3.accept("xml").delete();
       wc.reset();
   }
   
   public static void postJSONResorse(WebClient wc) throws IOException{
        /*Response response = null;
        Gson gson = new Gson();
        //Risorsa2 resJSON = (Risorsa2) gson.fromJson(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), Risorsa2.class);
        //System.out.print("\n\nrisorsa JSON:\t"+resJSON.toString());
        
        Risorsa2 r3= new Risorsa2();
        r3.setName("Risorsa bella");
        r3.setId("sei");
        r3.setFoundation(LocalDate.now());
        BufferedWriter writer = new BufferedWriter(new FileWriter("res.json"));
        writer.write(gson.toJson(r3));
        writer.close();
        File file = new File("res.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        FileInputStream targetStream = new FileInputStream(file);
        wc.accept("application/json").post(targetStream);*/
        Response r=wc.path("tre").accept("application/json").get();
        System.out.println( new String(((InputStream)r.getEntity()).readAllBytes(),StandardCharsets.UTF_8));
                
   }
}
