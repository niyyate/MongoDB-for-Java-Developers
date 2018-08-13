/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.*;
import spark.Spark;
import static spark.Spark.halt;
import org.apache.log4j.*;

/**
 *
 * @author MrsGrandChamps
 */
public class HelloWorldSparkFreeMarkerStyle {

    final static Logger logger = Logger.getLogger("HelloWorldSparkFreeMarkerStyle.class");

    public static void main(String[] args) {
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");

        logger.info("Entering the Main method");
        Spark.get("/", (req, res) -> {

            StringWriter writer = new StringWriter();

            try {
                Template helloTemplate = configuration.getTemplate("hello.ftl");

                Map<String, Object> HelloMap = new HashMap<String, Object>();

                HelloMap.put("name", "Freemarker");

                helloTemplate.process(HelloMap, writer);
                System.out.println(writer);

            } catch (Exception ex) {
                logger.error("The Map Did Not Run!");
                throw Spark.halt(500);

            }
            logger.info("Exiting the Main method");
            return writer;
        }
        );
    }

}
