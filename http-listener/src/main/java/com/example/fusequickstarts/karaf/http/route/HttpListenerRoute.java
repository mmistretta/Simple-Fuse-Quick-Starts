package com.example.fusequickstarts.karaf.http.route;

import org.apache.camel.builder.RouteBuilder;

public class HttpListenerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("jetty:http://0.0.0.0:8182/sample")
            .routeId("http-listener")
            .log("Request Received");
    }
    
}
