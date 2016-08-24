package com.example.fusequickstarts.karaf.jms.route;

import org.apache.camel.builder.RouteBuilder;

public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("jms:queue:jmsTestQueue?clientId=jmsConsumerRoute")
            .routeId("jmsConsumer")
            .to("direct:jmsConsumer");
        
        from("direct:jmsConsumer")
            .routeId("directJmsConsumer")
            .setBody().simple("Received Message: ${body}")
            .to("log:jmsConsumerLog");
    }

}
