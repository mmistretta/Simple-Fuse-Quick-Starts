package com.example.fusequickstarts.karaf.jms.route;

import org.apache.camel.builder.RouteBuilder;

public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("timer://myTimer?fixedRate=true&period=2000")
            .routeId("amqProducer")
            .transform().simple("Sample AMQ Message")
            .log("Created Message: ${body}")
            .to("activemq:queue:TestQueue");
    }

}
