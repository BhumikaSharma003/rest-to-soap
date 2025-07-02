package com.example.rest_to_soap.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(endpointInterface = "com.example.rest_to_soap.soap.MockSoapServiceEndpoint")
public class MockSoapService implements MockSoapServiceEndpoint {

    @Override
    @WebMethod
    public String registerPlan(String mobileNumber, String planName, int dataAllowance, int sms, int voice) {
        // Simulate saving or processing
        System.out.println("SOAP service received:");
        System.out.println("Mobile: " + mobileNumber);
        System.out.println("Plan: " + planName);
        System.out.println("Data: " + dataAllowance);
        System.out.println("SMS: " + sms);
        System.out.println("Voice: " + voice);

        return "success";
    }
}
