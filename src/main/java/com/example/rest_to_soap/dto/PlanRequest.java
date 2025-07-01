package com.example.rest_to_soap.dto;

import lombok.Data;

@Data
public class PlanRequest {
    private String mobileNumber;
    private String planName;
    private int dataAllowance;
    private int sms;
    private int voice;
}