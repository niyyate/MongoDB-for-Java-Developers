# Adding Spark To Maven Project
```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongdodb;

import org.apache.log4j.*;
//use this import for logging it has more options 
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author MrsGrandChamps
 */
```
 *Spark is a Micro Web FrameWork
 * Spark is in Maven Central so no need to add the repository BUT add the dependency
 * most Recent version  

```java
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>2.7.2</version>
        </dependency>        
```
        * apps the spark invoke call SL4j and that requires logger set up (See Logger Notes)
```java
public class HelloWorldSparkStyle {
    final static Logger logger = Logger.getLogger("HelloWorldSparkStyle.class");
    //stactic and final bc you only define it one time 
    
    public static void main(String[] args) {
        logger.info("Entering the Main method"); //testing logging 
        
```
## Routes
A route is made up of three simple pieces:

A verb (get, post, put, delete, head, trace, connect, options)
A path (/hello, /users/:name)
A callback (request, response) -> { }

### There are two ways of setting routes:
This is the older version 
```java
        Spark.get("/", new Route() {

            @Override
            public Object handle(final Request request, final Response response) {
                return "Hello World From Spark!";
            }
        });        
```
This is the new version 
```java
        Spark.get("/", ( req, res) -> "Hello World From Spark!");            
        
        
```
Check log files to find out what port you are running on currenly i am on 4567 using Spark 
```java
        logger.info("Exiting the Main method");//testing loffing 
    }
}
```
