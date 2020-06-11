package com.hireslate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.repository.CompanyMasterRepository;

@Service
public class CompanyMasterService {

	@Autowired
	CompanyMasterRepository companyMasterRepository;
	
	public  String insertCompanyMaster(CompanyMasterEntity company,HttpServletRequest request) {
		String companyName = companyMasterRepository.insertAndGetId(company);
		String msg;
		if(companyName != null) {
			request.getSession().setAttribute("companyName", companyName);
			msg = "redirect:/user/company/login";
		}
		else {
			msg = "redirect:/user/company/register";
		}
		return msg;
	}
	
	public String doCompanyLogout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/user/company/login";
	}
	
	public String doCompanyLogin(String username, String password, HttpServletRequest request) {
		
		String msg;
		try {
			CompanyMasterEntity company = companyMasterRepository.getCompanyId(username, password);
			request.getSession().setAttribute("companyId", company.getCompanyId());
			request.getSession().setAttribute("companyName", company.getCompanyName());
			request.getSession().setAttribute("companyLoginMsg", "Success");
			request.getSession().setAttribute("logoUrl", "https://hireslate.s3.ap-south-1.amazonaws.com/company/"+(int)request.getSession().getAttribute("companyId")+"/logo.png");
			msg = "redirect:/admin/dashboard";
		}
		catch(NullPointerException e) {
			request.getSession().setAttribute("companyLoginMsg", "Failed");
			msg = "redirect:/user/company/login";
		
		}
	
		return msg;
	}
	
	public void updateComapanyMaster(CompanyMasterEntity company) {
	}
	
	public List<CompanyMasterEntity> viewOnlyIdCompanyMaster(){
		return companyMasterRepository.viewOnlyId();
	}
	
	public int getLastCompanyId() {
		return companyMasterRepository.getLastId();
	}
	
	public CompanyMasterEntity getCompany(int companyId) {
		return companyMasterRepository.getCompany(companyId);
	}
}
