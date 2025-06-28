package com.example.rest_to_soap.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String sendToSoapService(String message) {
        // Simulate SOAP service call for now
        return "SOAP service received: " + message;
    }
}