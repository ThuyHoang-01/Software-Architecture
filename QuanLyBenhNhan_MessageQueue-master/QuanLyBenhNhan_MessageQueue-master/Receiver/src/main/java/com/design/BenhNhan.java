/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.design;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author quant
 */
@XmlRootElement
@XmlType(propOrder = {"msbn","cmnd","hoten","diachi"})
public class BenhNhan implements Serializable{
    private String msbn;
    private String cmnd;
    private String hoten;
    private String diachi;

    public BenhNhan(String msbn, String cmnd, String hoten, String diachi) {
        this.msbn = msbn;
        this.cmnd = cmnd;
        this.hoten = hoten;
        this.diachi = diachi;
    }

    public BenhNhan() {
    }

    public String getMsbn() {
        return msbn;
    }

    public void setMsbn(String msbn) {
        this.msbn = msbn;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "BenhNhan{" + "msbn=" + msbn + ", cmnd=" + cmnd + ", hoten=" + hoten + ", diachi=" + diachi + '}';
    }
    
    
}
