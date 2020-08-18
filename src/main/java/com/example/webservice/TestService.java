package com.example.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author Administrator
 */
@WebService(name = "testService",targetNamespace = "http://webservice.example.com")
public interface TestService {

    /**
     * @param username
     * @return
     */
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    String sendMessageForName(@WebParam(name = "username") String username,@WebParam(name = "age") Integer age);

}

