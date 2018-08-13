# Forms With Spark / FM
```java
package com.mongodb;

/**
 *
 * @author MrsGrandChamps
 *
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 */
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SparkFormHandling {

    public static void main(String[] args) {
        // Configure Freemarker
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");

        // Configure routes
        Spark.get("/", (Req, resp) -> {

            try {

                Map<String, Object> fruitsMap = new HashMap<String, Object>();
//Creating an array list to pass in to the form 
                fruitsMap.put("fruits",
                        Arrays.asList("apple", "orange", "banana", "peach"));

                Template fruitPickerTemplate
                        = configuration.getTemplate("fruitPicker.ftl");
                StringWriter writer = new StringWriter();
                fruitPickerTemplate.process(fruitsMap, writer);
                return writer;

            } catch (Exception e) {
                Spark.halt(500);
                return null;
            }
        });
//Creats a post(add) that shows your answer. 
        Spark.post("/favorite_fruit", (req, resp) -> {
            final String fruit = req.queryParams("fruit");
            if (fruit == null) {
                return "Why don't you pick one?";
            } else {
                return "Your favorite fruit is " + fruit;
            }

        });
    }
}
```

this is the HTML for the Form 
```html
<html>
  <head><title>Fruit Picker</title></head>
  <body>
     <form action="/favorite_fruit" method="POST">
        <p>What is your favorite fruit?</p>
        <#list fruits as fruit>
          <p>
             <input type="radio" name="fruit" value="${fruit}">${fruit}</input>
          </p>
        </#list>
        <input type="submit" value="Submit"/>
     </form>
  </body>
</html>
```
