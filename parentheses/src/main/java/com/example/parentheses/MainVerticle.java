package com.example.parentheses;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * MainVerticle class
 */

public class MainVerticle extends AbstractVerticle {

    /**
     * The main function to fire up the server and calls/do the repsective function.
     * REST endpoint: POST localhost:8080/checkParentheses
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.route(HttpMethod.POST, "/checkParentheses").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            JsonObject jsonObject = routingContext.getBodyAsJson();
            String input = jsonObject.getString("input");
            int result = Parentheses.findMistakes(input.split(""));
            response
                .putHeader("content-type", "text/html")
                .end("Found " + result + " mistake(s) from the input.");
        });

    	vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        System.out.println("HTTP server started on port 8080");
    }
}
