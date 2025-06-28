package com.example.rest_to_soap.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(endpointInterface = "com.example.rest_to_soap.soap.MockSoapServiceEndpoint")
public class MockSoapService implements MockSoapServiceEndpoint {

    @WebMethod
    public String receiveMessage(String message) {
        return "SOAP service received: " + message;
    }
}