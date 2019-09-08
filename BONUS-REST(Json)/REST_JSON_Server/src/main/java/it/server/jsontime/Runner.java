/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.server.jsontime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author lorenzo
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(ServiceRepository.class);
        factoryBean.setResourceProvider(
            new SingletonResourceProvider(new ServiceRepository()));
        Map<Object,Object> emap = new HashMap<Object,Object>();
         emap.put("json", MediaType.APPLICATION_JSON);
        factoryBean.setExtensionMappings(emap);
        
       
        factoryBean.setProvider(new JacksonJsonProvider());
        
        
        
        factoryBean.setAddress("http://localhost:7580/");
        
        Server server = (Server) factoryBean.create();
    }
}
