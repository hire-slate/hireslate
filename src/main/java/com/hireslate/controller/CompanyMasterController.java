package com.hireslate.controller;

import javax.servlet.http.HttpServletRequest;

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
									@RequestParam("companyUsername") String companyUsername, @RequestParam("companyPassword") String companyPassword,
									@RequestParam("companyCPassword") String companyCPassword,@RequestParam("companyContact") String companyContact, @RequestParam("companyPancard") String companyPancard,
									@RequestParam("companyAddress") String companyAddress,@RequestParam("companyLandmark") String companyLandmark,@RequestParam("companyCity") String companyCity,
									@RequestParam("companyPincode") String companyPincode, @RequestParam("companyState") String companyState,@RequestParam("companyGST") String companyGST,HttpServletRequest request) {

		String msg;
		if(companyPassword.equals(companyCPassword)) {
		CompanyMasterEntity company = new CompanyMasterEntity();
		company.setCompanyName(companyName);
		company.setCompanyContact(companyContact);
		company.setCompanyWebsite(companyWebsite);
		company.setCompanyUsername(companyUsername);
		company.setCompanyPassword(companyPassword);
		company.setCompanyPancard(companyPancard);
		company.setCompanyAddressLine(companyAddress);
		company.setCompanyPincode(Integer.parseInt(companyPincode));
		company.setCompanyLandmark(companyLandmark);
		company.setCompanyGstin(companyGST);
		company.setCompanyCity(companyCity);
		
		msg = companyMasterService.insertCompanyMaster(company,request);
		}
		else {
			msg = "redirect:/user/company/register";
		}
		return msg;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String showLoginPage(Model model){
		return "admin/login.jsp";
	}

	@RequestMapping(value = "/dologin")
	public String doLogin(@RequestParam("companyUsername") String username,@RequestParam("companyPassword") String password,HttpServletRequest request) {
		String msg;
		msg = companyMasterService.doCompanyLogin(username,password,request);
		System.out.println(msg);
		return msg;
	}
	
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String doLogout(HttpServletRequest request) {
		String msg = companyMasterService.doCompanyLogout(request);
		return msg;
	}
	
	@RequestMapping(value = "/companyregister", method = RequestMethod.GET )
	public String showCompanyRegisterPage(Model model){
		return "user/companyregister.jsp";
	}
}