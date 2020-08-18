package com.example.webservice;

import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author Administrator
 */
@Configuration
public class CxfConfig{

    @Autowired
    private Bus bus;

    @Autowired
    private TestService testService;


    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/TestService");
        return endpoint;
    }
}
