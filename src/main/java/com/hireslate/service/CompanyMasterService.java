package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.repository.CompanyMasterRepository;

@Service
public class CompanyMasterService {

	@Autowired
	CompanyMasterRepository companyMasterRepository;
	
	public void insertCompanyMaster(CompanyMasterEntity company) {
		companyMasterRepository.insert(company);
	}
	
	public void updateComapnyMaster(CompanyMasterEntity company) {
		companyMasterRepository.update(company);
	}
	
	public List<CompanyMasterEntity> viewOnlyIdCompanyMaster(){
		return companyMasterRepository.viewOnlyId();
	}
	
}
