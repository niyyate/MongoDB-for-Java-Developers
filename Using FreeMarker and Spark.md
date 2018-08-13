# Using FreeMarker and Spark
Free Marker is a Templating Engine 
Define Template files wtih .ftl
these files are combined with Map and print out the compination 

```java
package com.mongdodb;

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
    //FreeMaker Config 
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");

        logger.info("Entering the Main method");
    // Spark path and call back open 
        Spark.get("/", (req, res) -> {
    //Freemaker temp + data 
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
        //Spark call back closed
    }

}

```
