/**
 * CalculatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hoangtothuy.org;

public class CalculatorServiceLocator extends org.apache.axis.client.Service implements hoangtothuy.org.CalculatorService {

    public CalculatorServiceLocator() {
    }


    public CalculatorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculatorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Calculator
    private java.lang.String Calculator_address = "http://localhost:8080/19432541_HoangThiToThuy/services/Calculator";

    public java.lang.String getCalculatorAddress() {
        return Calculator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculatorWSDDServiceName = "Calculator";

    public java.lang.String getCalculatorWSDDServiceName() {
        return CalculatorWSDDServiceName;
    }

    public void setCalculatorWSDDServiceName(java.lang.String name) {
        CalculatorWSDDServiceName = name;
    }

    public hoangtothuy.org.Calculator getCalculator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Calculator_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculator(endpoint);
    }

    public hoangtothuy.org.Calculator getCalculator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hoangtothuy.org.CalculatorSoapBindingStub _stub = new hoangtothuy.org.CalculatorSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalculatorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculatorEndpointAddress(java.lang.String address) {
        Calculator_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (hoangtothuy.org.Calculator.class.isAssignableFrom(serviceEndpointInterface)) {
                hoangtothuy.org.CalculatorSoapBindingStub _stub = new hoangtothuy.org.CalculatorSoapBindingStub(new java.net.URL(Calculator_address), this);
                _stub.setPortName(getCalculatorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Calculator".equals(inputPortName)) {
            return getCalculator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://org.hoangtothuy", "CalculatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://org.hoangtothuy", "Calculator"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Calculator".equals(portName)) {
            setCalculatorEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
