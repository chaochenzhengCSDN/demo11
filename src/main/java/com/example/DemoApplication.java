package com.example;

import com.hodo.group2.hdcloud.employee.information.entity.*;
import io.swagger.models.auth.In;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import weaver.workflow.webservices.*;

import java.beans.Transient;
import java.util.*;

/**
 * @author Administrator
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
        Client client=factory.createClient("http://localhost:8080/services/TestService?wsdl");
        try {
            Object[] objects=new Object[0];
            objects=client.invoke("sendMessageForName","zcc",23);
            System.out.println("objects[0] = " + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JaxWsDynamicClientFactory factory1=JaxWsDynamicClientFactory.newInstance();
        Client client1=factory1.createClient("http://10.10.62.204/services/WorkflowService?wsdl");
        Object[] objects1=new Object[0];
        WorkflowRequestInfo workflowRequestInfo = new OfficerUtil().getWorkflowRequestInfo("122");
        WorkflowRequestInfo workflowRequestInfo1= new SalesclerkUtil().getWorkflowRequestInfo("122");
        WorkflowRequestInfo workflowRequestInfo2= new StaffUtil().getWorkflowRequestInfo("122");
        try {
            objects1=client1.invoke("doCreateWorkflowRequest",workflowRequestInfo,new Integer(1));
            String res= (String) objects1[0];
            System.out.println("objects = " + res);
//            WorkflowServiceHttpBindingStub binding = (WorkflowServiceHttpBindingStub) new WorkflowServiceLocator().getWorkflowServiceHttpPort();
//            String res1 = binding.doCreateWorkflowRequest(workflowRequestInfo,1);
//            System.out.println("res1 = " + res1);
//            WorkflowServiceHttpBindingStub binding1 = (WorkflowServiceHttpBindingStub) new WorkflowServiceLocator().getWorkflowServiceHttpPort();
//            String res2 = binding.doCreateWorkflowRequest(workflowRequestInfo1,1);
//            System.out.println("res2 = " + res2);
//            WorkflowServiceHttpBindingStub binding2 = (WorkflowServiceHttpBindingStub) new WorkflowServiceLocator().getWorkflowServiceHttpPort();
//            String res3 = binding.doCreateWorkflowRequest(workflowRequestInfo2,1);
//            System.out.println("res3 = " + res3);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
