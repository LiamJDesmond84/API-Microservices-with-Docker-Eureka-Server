package com.liam.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liam.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	

}
