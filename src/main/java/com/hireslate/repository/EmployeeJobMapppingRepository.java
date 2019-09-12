package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.EmployeeJobMappingEntity;

@Repository
public class EmployeeJobMapppingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(EmployeeJobMappingEntity employeeJobMappingEntity) {
		String sql ="";
		
	}
}
