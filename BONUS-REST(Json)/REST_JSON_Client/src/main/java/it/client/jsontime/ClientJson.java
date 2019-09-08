/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.client.jsontime;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author lorenzo
 */
public class ClientJson {
    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        String baseurl = "http://localhost:7580/news/";
        URL newstuff=new URL(baseurl+"newStuff");
        InputStream i =newstuff.openStream();
        String news = convert(i,Charset.defaultCharset());
        System.out.println(news);
        i.close();
        
        //tipo di dato creato da me
        Client client = ClientBuilder.newBuilder()
            .register(JacksonJsonProvider.class)
            .build();
        Response jsonresponse = client.target(baseurl+"specialNews/9").request(MediaType.APPLICATION_JSON).get();
        SpecialNews mynews = jsonresponse.readEntity(SpecialNews.class);
        System.out.println(mynews.toString());
        //EntityUtils.consume((HttpEntity) jsonresponse.getEntity());
        
        
        
        while(true){
            String inputNews = JOptionPane.showInputDialog("manda una news-valore");
            if(inputNews.equals("")||!inputNews.contains("-")){
                break;
            }
            inputNews = inputNews.replace(" ", "_");
            String[] posturl=inputNews.split("-");
            
            
            
            HttpClient httpclient = HttpClients.createDefault();
            

            HttpPost postMethod = new HttpPost(baseurl+"postaSpecialNews/"+posturl[0]+"/"+new Integer(posturl[1]));
           

            HttpResponse rawResponse = httpclient.execute(postMethod);
            System.out.println(rawResponse.getStatusLine());
            
            
           
            
            System.out.println("Tra poco ti richiedo una news...");
            Thread.sleep(10000);
        }
        jsonresponse = client.target(baseurl+"sendaNewsList").request(MediaType.APPLICATION_JSON).get();
        NewsList newsList=jsonresponse.readEntity(NewsList.class);
        System.out.println(newsList.toString());
        
        
        
        
        
    }
    
    public static String convert(InputStream inputStream, Charset charset) throws IOException {
 
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
                	return br.lines().collect(Collectors.joining(System.lineSeparator()));
            }
       }
   
    
}
