package com.example.rest_to_soap.repository;

import com.example.rest_to_soap.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}