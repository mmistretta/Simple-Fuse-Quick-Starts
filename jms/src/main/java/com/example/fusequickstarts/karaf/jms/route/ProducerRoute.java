package com.example.fusequickstarts.karaf.jms.route;

import org.apache.camel.builder.RouteBuilder;

public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("timer://myTimer?fixedRate=true&period=2000")
            .routeId("jmsProducer")
            .to("direct:jmsProducer");
        
        from("direct:jmsProducer")
            .routeId("directJmsProducer")
            .transform().simple("Sample JMS Message")
            .log("Created Message: ${body}")
            .to("jms:queue:jmsTestQueue?clientId=jmsProducerRoute");
    }

}
