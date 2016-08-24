package com.example.fusequickstarts.karaf.jms.route;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("activemq:queue:TestQueue")
            .routeId("amqConsumer")
            .setBody().simple("Received Message: ${body}")
            .to("log:jmsConsumerLog");
    }

}
