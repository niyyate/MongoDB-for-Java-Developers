# Free Marker with Maven
```java
package com.mongdodb;

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
```
A Configuration instance is the central place to store the application level settings of FreeMarker.    
Thisis the most up to date version of this decliration 
```java
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
        
```

Specify the source where the template files come from. Here I set a plain directory for it, but non-file-system sources are possible too: 
Relative base path - in or around the .class
/ - with this config FreeMarker will look **[your project]/src/main/resources/template.ftl**
```java
                                configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");

```
There are other config options see [FreeMakerDocs](https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html)
```java
        try {
        // using config to get the tempate 
            Template helloTemplate = configuration.getTemplate("hello.ftl");
        
        // creating a write to output the template 
            StringWriter writer = new StringWriter();
        //creating a object data modle that definds the paramiters of our Map
            Map<String, Object> HelloMap = new HashMap<String, Object>();

        //where you have string name put FreeMarker
            HelloMap.put("name", "FreeMarker");
        //have the template process what is in the Map and write it 
            helloTemplate.process(HelloMap, writer);
        // Prnt in consoul
            System.out.println(writer);

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(HelloWorldFreeMarkerStyle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
```
