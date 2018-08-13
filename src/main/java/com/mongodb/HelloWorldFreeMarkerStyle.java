/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb;

import freemarker.template.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;

/**
 *
 * @author MrsGrandChamps
 */
public class HelloWorldFreeMarkerStyle {

    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");

            StringWriter writer = new StringWriter();

            
            Map<String, Object> HelloMap = new HashMap<String, Object>();

            
            HelloMap.put("name", "Freemarker");

            helloTemplate.process(HelloMap, writer);
            
            System.out.println(writer);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HelloWorldFreeMarkerStyle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
