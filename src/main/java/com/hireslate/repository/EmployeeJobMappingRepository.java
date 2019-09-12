package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.EmployeeJobMappingEntity;

@Repository
public class EmployeeJobMappingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(EmployeeJobMappingEntity employeeJobMappingEntity) {
		String sql ="INSERT INTO `employee_job_mapping`(`Employee_Id`, `Job_Id`, `Employee_Role`) VALUES "
				+ "("+employeeJobMappingEntity.getEmployeeId()+","+employeeJobMappingEntity.getJobId()+",'"+employeeJobMappingEntity.getEmployeeRole()+"')";
		jdbcTemplate.execute(sql);
	}
}
