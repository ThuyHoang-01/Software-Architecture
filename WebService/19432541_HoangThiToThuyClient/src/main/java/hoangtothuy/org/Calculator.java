/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hoangtothuy.org;

public interface Calculator extends java.rmi.Remote {
    public double product(double a, double b) throws java.rmi.RemoteException;
    public double add(double a, double b) throws java.rmi.RemoteException;
    public double sub(double a, double b) throws java.rmi.RemoteException;
    public double div(double a, double b) throws java.rmi.RemoteException;
}
