package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.EmployeeMasterEntity;
import com.hireslate.repository.EmployeeMasterRepository;

@Service
public class EmployeeMasterService {

	@Autowired
	EmployeeMasterRepository employeeMasterRepository;
	
	public List<EmployeeMasterEntity> viewEmployeeMaster(){
		return employeeMasterRepository.view();
	}
	
	public void insertEmployeeMaster(EmployeeMasterEntity employeeMasterEntity) {
		employeeMasterRepository.insert(employeeMasterEntity);
	}
	
	public void updateEmployeeMaster(EmployeeMasterEntity employeeMasterEntity) {
		employeeMasterRepository.update(employeeMasterEntity);
	}
	
	public EmployeeMasterEntity viewByIdEmployeeMaster(int id) {
		return employeeMasterRepository.viewById(id);
	}
	public void deleteEmployeeMaster(int id) {
		employeeMasterRepository.delete(id);
	}
}
