package com.example.rest_to_soap.client;

import com.example.rest_to_soap.soap.MockSoapServiceEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

@Component
public class SoapClient {
    private static final Logger logger = LoggerFactory.getLogger(SoapClient.class);

    public boolean callSoapService(String mobileNumber, String planName, int dataAllowance, int sms, int voice) {
        try {
            URL wsdlURL = new URL("http://localhost:8080/ws/mockSoapService?wsdl");
            QName qname = new QName("http://soap.rest_to_soap.example.com/", "MockSoapServiceService");
            Service service = Service.create(wsdlURL, qname);
            MockSoapServiceEndpoint port = service.getPort(MockSoapServiceEndpoint.class);

            String response = port.registerPlan(mobileNumber, planName, dataAllowance, sms, voice);
            boolean success = response != null && response.contains("success");
            if (success) {
                logger.info("SOAP call succeeded for mobileNumber: {}", mobileNumber);
            }
            return success;
        } catch (Exception e) {
            logger.error("SOAP call failed for mobileNumber: {} - {}", mobileNumber, e.getMessage());
            return false;
        }
    }
}