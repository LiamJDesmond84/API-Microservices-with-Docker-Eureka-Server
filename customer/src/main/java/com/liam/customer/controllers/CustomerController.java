package com.liam.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liam.customer.models.CustomerRegistrationRequest;
import com.liam.customer.services.CustomerService;

//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
//@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	private final CustomerService customerService;
	

	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		log.info("new customer registration {}", customerRegistrationRequest);
		customerService.registerCustomer(customerRegistrationRequest);
	}
}
