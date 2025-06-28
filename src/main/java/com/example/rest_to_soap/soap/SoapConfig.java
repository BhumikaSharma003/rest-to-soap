package com.example.rest_to_soap.soap;

import jakarta.xml.ws.Endpoint;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Configuration
public class SoapConfig {

    @PostConstruct
    public void publishSoapService() {
        Endpoint.publish("http://localhost:8080/ws/mockSoapService", new MockSoapService());
    }
}