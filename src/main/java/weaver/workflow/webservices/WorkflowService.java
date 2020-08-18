/**
 * WorkflowService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package weaver.workflow.webservices;

public interface WorkflowService extends javax.xml.rpc.Service {
    String getWorkflowServiceHttpPortAddress();

    WorkflowServicePortType getWorkflowServiceHttpPort() throws javax.xml.rpc.ServiceException;

    WorkflowServicePortType getWorkflowServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
