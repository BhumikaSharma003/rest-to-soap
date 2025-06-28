package com.example.rest_to_soap.client;

import org.springframework.stereotype.Component;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;
import com.example.rest_to_soap.soap.MockSoapServiceEndpoint; // Use the interface

@Component
public class SoapClient {

    public String callSoapService(String message) {
        try {
            URL wsdlURL = new URL("http://localhost:8080/ws/mockSoapService?wsdl");
            QName qname = new QName("http://soap.rest_to_soap.example.com/", "MockSoapServiceService");
            Service service = Service.create(wsdlURL, qname);
            MockSoapServiceEndpoint port = service.getPort(MockSoapServiceEndpoint.class); // Use the interface
            return port.receiveMessage(message);
        } catch (Exception e) {
            return "Error calling SOAP service: " + e.getMessage();
        }
    }
}