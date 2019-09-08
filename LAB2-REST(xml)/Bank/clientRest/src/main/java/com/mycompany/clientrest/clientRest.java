/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientrest;

import com.mycompany.restserverbank.Conto;
import com.mycompany.restserverbank.ListofConto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

/**
 *
 * @author lorenzo
 */
public class clientRest {
    final static private String BaseUrl = "http://localhost:8080/bank";
    

    public static void main(String[] args) throws IOException, JAXBException {
        
        ListofConto conti;
        URL url = new URL(BaseUrl + "/conto/getconti");
        InputStream input = url.openStream();
        conti = JAXB.unmarshal(new InputStreamReader(input), ListofConto.class);
        System.out.println(conti.getConti().size());
        for(Conto c:conti.getConti()){
            System.out.println(c.toString());
        }
        input.close();
        URL url2 = new URL(BaseUrl + "/transaction/22");
        InputStream input2 = url2.openStream();
        String transazione = convert(input2,Charset.defaultCharset());
        System.out.println(transazione);
   
    }

        public static String convert(InputStream inputStream, Charset charset) throws IOException {
 
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
                	return br.lines().collect(Collectors.joining(System.lineSeparator()));
            }
       }
}
