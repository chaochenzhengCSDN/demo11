/**
 * WorkflowServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package weaver.workflow.webservices;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://webservice.workflow.weaver")
public interface WorkflowServicePortType extends java.rmi.Remote {
    boolean deleteRequest(int in0, int in1) throws java.rmi.RemoteException;
    String submitWorkflowRequest(WorkflowRequestInfo in0, int in1, int in2, String in3, String in4) throws java.rmi.RemoteException;
    int getToDoWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    String getUserId(String in0, String in1) throws java.rmi.RemoteException;
    @WebMethod
    String doCreateWorkflowRequest(WorkflowRequestInfo in0, int in1) throws java.rmi.RemoteException;
    WorkflowRequestInfo getCreateWorkflowRequestInfo(int in0, int in1) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getAllWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getMyWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    WorkflowRequestInfo getWorkflowRequest(int in0, int in1, int in2) throws java.rmi.RemoteException;
    String forward2WorkflowRequest(int in0, String in1, String in2, int in3, String in4) throws java.rmi.RemoteException;
    int getProcessedWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    String getLeaveDays(String in0, String in1, String in2, String in3, String in4) throws java.rmi.RemoteException;
    WorkflowRequestInfo getWorkflowRequest4Split(int in0, int in1, int in2, int in3) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getHendledWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    int getCreateWorkflowCount(int in0, int in1, String[] in2) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getToDoWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    String[] getWorkflowNewFlag(String[] in0, String in1) throws java.rmi.RemoteException;
    String givingOpinions(int in0, int in1, String in2) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getCCWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    WorkflowBaseInfo[] getCreateWorkflowList(int in0, int in1, int in2, int in3, int in4, String[] in5) throws java.rmi.RemoteException;
    WorkflowRequestLog[] getWorkflowRequestLogs(String in0, String in1, int in2, int in3, int in4) throws java.rmi.RemoteException;
    int getCCWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    int getAllWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    int getMyWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    WorkflowRequestInfo[] getProcessedWorkflowRequestList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
    String doForceOver(int in0, int in1) throws java.rmi.RemoteException;
    int getCreateWorkflowTypeCount(int in0, String[] in1) throws java.rmi.RemoteException;
    String forwardWorkflowRequest(int in0, String in1, String in2, int in3, String in4) throws java.rmi.RemoteException;
    void writeWorkflowReadFlag(String in0, String in1) throws java.rmi.RemoteException;
    int getHendledWorkflowRequestCount(int in0, String[] in1) throws java.rmi.RemoteException;
    WorkflowBaseInfo[] getCreateWorkflowTypeList(int in0, int in1, int in2, int in3, String[] in4) throws java.rmi.RemoteException;
}
