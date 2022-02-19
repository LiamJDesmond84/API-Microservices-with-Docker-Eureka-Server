package com.liam.fraud.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.fraud.models.FraudCheckHistory;
import com.liam.fraud.repositories.FraudCheckHistoryRepository;

//import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class FraudCheckHistoryService {
	
	
	@Autowired
	private FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
//	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
	

	
	public boolean isFraudulentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(
				FraudCheckHistory.builder()
				.customerId(customerId)
				.isFraudster(false)
				.createdAt(LocalDateTime.now())
				.build()
		);
		return false; // We would normally actually check this, but this is just for whatever
	}

}
