package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author MongoClass
 */
public class SparkRoutes {

    public static void main(String[] args) {

        Spark.get("/hello", (request, response) -> {

            return "Hello World\n";
        }
        );

        Spark.get("/test", (Request, response) -> {

            return "This is a test page\n";

        });

        Spark.get("/echo/:thing", ((request, response) -> {
            return request.params(":thing");

        }));

    }
}
