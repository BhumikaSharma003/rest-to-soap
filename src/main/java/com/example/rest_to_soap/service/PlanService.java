package com.example.rest_to_soap.service;

import com.example.rest_to_soap.dto.PlanRequest;
import com.example.rest_to_soap.entity.PlanEntity;
import com.example.rest_to_soap.repository.PlanRepository;
import com.example.rest_to_soap.client.SoapClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    private static final Logger logger = LoggerFactory.getLogger(PlanService.class);

    @Autowired
    private SoapClient soapClient;

    @Autowired
    private PlanRepository planRepository;

    public String processPlan(PlanRequest request) {
        // Step 1: Call SOAP API
        boolean soapSuccess = soapClient.callSoapService(
                request.getMobileNumber(),
                request.getPlanName(),
                request.getDataAllowance(),
                request.getSms(),
                request.getVoice()
        );

        if (!soapSuccess) {
            // Step 2: Log failure
            logger.error("SOAP API failed for mobileNumber: {}", request.getMobileNumber());
            return "Failed to process plan due to SOAP error";
        }

        // Step 3: On success, save to database
        PlanEntity entity = new PlanEntity();
        entity.setMobileNumber(request.getMobileNumber());
        entity.setPlanName(request.getPlanName());
        entity.setDataAllowance(request.getDataAllowance());
        entity.setSms(request.getSms());
        entity.setVoice(request.getVoice());
        planRepository.save(entity);

        logger.info("Plan saved successfully for mobileNumber: {}", request.getMobileNumber());
        return "Plan processed and saved successfully";
    }
}