/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb;

import org.apache.log4j.*;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author MrsGrandChamps
 * Spark is a Micro Web FrameWork
 * Spark is in Maven Central so no need to add the repository BUT add the dependency. 
 */
public class HelloWorldSparkStyle {

    final static Logger logger = Logger.getLogger("HelloWorldSparkStyle.class");
    public static void main(String[] args) {
        logger.info("Entering the Main method");
        
        Spark.get("/", ( req, res) -> "Hello World From Spark!");
         
        logger.info("Exiting the Main method");
 
    }
}
