/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserverbank;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author lorenzo
 */
public class RunnerClass {
    public static void main(String[] args) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        
        factoryBean.setResourceClasses(BankRepository.class);
        factoryBean.setResourceProvider(
            new SingletonResourceProvider(new BankRepository()));
        factoryBean.setAddress("http://localhost:8080/");
        
        Server server = (Server) factoryBean.create();
    }
}
