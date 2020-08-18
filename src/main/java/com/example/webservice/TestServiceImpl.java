package com.example.webservice;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author Administrator
 */

@WebService(name = "TestService",targetNamespace = "http://webservice.example.com",
        endpointInterface = "com.example.webservice.TestService")
@Component
public class TestServiceImpl implements TestService {
    @Override
    public String sendMessageForName(String username,Integer age) {
        return "hello"+username+"今年"+age+"岁";
    }
}
