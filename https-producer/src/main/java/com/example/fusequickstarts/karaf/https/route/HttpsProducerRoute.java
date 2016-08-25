package com.example.fusequickstarts.karaf.https.route;

import org.apache.camel.builder.RouteBuilder;

public class HttpsProducerRoute extends RouteBuilder {
	
    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("timer://myHttpsTimer?fixedRate=true&period=2000")
            .routeId("https-producer")
            //TODO make https
            .to("http://127.0.0.1:8182/sample");
    }

}
