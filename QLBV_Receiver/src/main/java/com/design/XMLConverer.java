/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.design;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author quant
 */

public class XMLConverer<T> {
    private T type;
    
    public XMLConverer(T type){
        this.type = type;
    }
    
    @SuppressWarnings("all")
    public T xmlToObject(String xml) throws Exception{
        T bn = null;
        JAXBContext ctx = JAXBContext.newInstance(type.getClass());
        Unmarshaller ms = ctx.createUnmarshaller();
        bn = (T) ms.unmarshal(new StringReader(xml));
        
        System.out.println(bn);
        
        return bn;
    }
}
