package com.hireslate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.service.CompanyMasterService;

@Controller
@RequestMapping("/user/company")
public class CompanyMasterController {
	
	
	@Autowired
	CompanyMasterService companyMasterService;
	

	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String showCandidateRegisterForm() {
		return "user/companyregister.jsp";
	}

	@RequestMapping(value = "/register/new", method=RequestMethod.POST)
	public String RegisterCompany(Model model,@RequestParam("companyName") String companyName , @RequestParam("companyWebsite") String companyWebsite,
									@RequestParam("companyContact") String companyContact, @RequestParam("companyPancard") String companyPancard,
									@RequestParam("companyAddress") String companyAddress,@RequestParam("companyLandmark") String companyLandmark,@RequestParam("companyCity") String companyCity,
									@RequestParam("companyPincode") String companyPincode, @RequestParam("companyState") String companyState,@RequestParam("companyGST") String companyGST) {
		
		CompanyMasterEntity company = new CompanyMasterEntity();
		company.setCompanyName(companyName);
		company.setCompanyContact(companyContact);
		company.setCompanyWebsite(companyWebsite);
		company.setCompanyPancard(companyPancard);
		company.setCompanyAddressLine(companyAddress);
		company.setCompanyPincode(Integer.parseInt(companyPincode));
		company.setCompanyLandmark(companyLandmark);
		company.setCompanyGstin(companyGST);
		company.setCompanyCity(companyCity);
		
		companyMasterService.insertCompanyMaster(company);
		return "redirect:/user/company/register";
	}
}