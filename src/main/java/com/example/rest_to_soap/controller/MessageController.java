package com.example.rest_to_soap.controller;

import com.example.rest_to_soap.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message) {
        String soapResponse = messageService.sendToSoapService(message);
        return "Message sent to SOAP service. Response: " + soapResponse;
    }
}