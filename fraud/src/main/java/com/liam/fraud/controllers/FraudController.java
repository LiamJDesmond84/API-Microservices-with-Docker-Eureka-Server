package com.liam.fraud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.fraud.models.FraudCheckResponse;
import com.liam.fraud.services.FraudCheckHistoryService;

import lombok.extern.slf4j.Slf4j;

//import lombok.AllArgsConstructor;

@RestController
//@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/fraud-check")
public class FraudController {
	

	@Autowired
	private  FraudCheckHistoryService fraudCheckService;
	
//	private final FraudCheckHistoryService fraudCheckService;

	
	
	@GetMapping("/{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
		Boolean isFraud =  fraudCheckService.isFraudulentCustomer(customerId);
		
		log.info("fraud check request for customer {}", customerId);
		
		return new FraudCheckResponse(isFraud);
		
	}

}
