package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.EmployeeMasterEntity;

@Repository
public class EmployeeMasterRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<EmployeeMasterEntity> view(){
		List<EmployeeMasterEntity> employee = new ArrayList<EmployeeMasterEntity>();
		String sql = "select * from employee_master";
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			EmployeeMasterEntity employeeEntity = new EmployeeMasterEntity();
			employeeEntity.setCompanyId((int)row.get("Company_Id"));
			employeeEntity.setEmployeeId((int)row.get("Employee_Id"));
			employeeEntity.setUserId((int)row.get("User_Id"));
			employee.add(employeeEntity);
		}
		return employee;
	}
	
	public void insert(EmployeeMasterEntity employeeMasterEntity) {
		String sql = "INSERT INTO `employee_master`(`Company_Id`, `User_Id`) VALUES ("+employeeMasterEntity.getCompanyId()+","+employeeMasterEntity.getUserId()+") ";
		jdbcTemplate.execute(sql);
	}
	
	public void update(EmployeeMasterEntity employeeMasterEntity) {
		String sql = "UPDATE `employee_master` SET `Company_Id`="+employeeMasterEntity.getCompanyId()+",`User_Id`="+employeeMasterEntity.getUserId()+" WHERE Employee_Id="+employeeMasterEntity.getEmployeeId();
		jdbcTemplate.execute(sql);
	}
	
	public EmployeeMasterEntity viewById(int id) {
		String sql ="select * from employee_master where Employee_Id = "+id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		EmployeeMasterEntity employeeMasterEntity = new EmployeeMasterEntity();
		employeeMasterEntity.setCompanyId((int)row.get("Company_Id"));
		employeeMasterEntity.setEmployeeId((int)row.get("Employee_Id"));
		employeeMasterEntity.setUserId((int)row.get("User_Id"));
		return employeeMasterEntity;
	}
	
	public void delete(int id) {
		String sql ="DELETE FROM `employee_master` WHERE User_Id="+id;
		jdbcTemplate.execute(sql);
	}
}
