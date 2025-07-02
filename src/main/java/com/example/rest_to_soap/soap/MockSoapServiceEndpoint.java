package com.example.rest_to_soap.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface MockSoapServiceEndpoint {
    @WebMethod
    String registerPlan(String mobileNumber, String planName, int dataAllowance, int sms, int voice);

}