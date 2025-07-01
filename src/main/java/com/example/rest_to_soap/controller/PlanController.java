package com.example.rest_to_soap.controller;

import com.example.rest_to_soap.dto.PlanRequest;
import com.example.rest_to_soap.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public String createPlan(@RequestBody PlanRequest request) {
        return planService.processPlan(request);
    }
}