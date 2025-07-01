package com.example.rest_to_soap.soap;

import jakarta.jws.WebService;
import org.springframework.stereotype.Component;

@Component
@WebService(endpointInterface = "com.example.rest_to_soap.soap.MockSoapServiceEndpoint")
public class MockSoapServiceImpl implements MockSoapServiceEndpoint {

    @Override
    public String registerPlan(String mobileNumber, String planName, int dataAllowance, int sms, int voice) {
        if (mobileNumber == null || mobileNumber.isEmpty()) {
            return null; // Simulate failure
        }
        return "success: Plan registered for " + mobileNumber;
    }

}