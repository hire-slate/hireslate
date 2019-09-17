package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.EmployeeJobMappingEntity;
import com.hireslate.repository.EmployeeJobMappingRepository;

@Service
public class EmployeeJobMappingService {

	@Autowired
	EmployeeJobMappingRepository employeeJobMappingRepository; 
	
	public void insertEmployeeJobMapping(EmployeeJobMappingEntity employeeJobMappingEntity ) {
		employeeJobMappingRepository.insert(employeeJobMappingEntity);
		
	}
}
