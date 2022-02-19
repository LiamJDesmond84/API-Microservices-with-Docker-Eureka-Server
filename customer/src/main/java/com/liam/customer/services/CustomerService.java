package com.liam.customer.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liam.customer.models.Customer;
import com.liam.customer.models.CustomerRegistrationRequest;
import com.liam.customer.models.FraudCheckResponse;
import com.liam.customer.repositories.CustomerRepository;

//import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	private final CustomerRepository customerRepository;
	
	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		customerRepository.saveAndFlush(customer);
		// saveAndFlush so we can have access to the customer Id
		// check if email not valid
		// check if email isn't taken
		// check if fraudster
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
				"http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
		
		if (fraudCheckResponse.isFraudster()) { // Can also check for null pointer as well after isFraudster()?
			throw new IllegalStateException("You're a fraud you son of a bitch!");
		}

		// send notification
	}

}
