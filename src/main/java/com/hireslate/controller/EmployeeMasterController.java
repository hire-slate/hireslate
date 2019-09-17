package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.EmployeeMasterEntity;
import com.hireslate.model.UserEntity;
import com.hireslate.service.CompanyMasterService;
import com.hireslate.service.EmployeeMasterService;
import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="admin/employee-master")
public class EmployeeMasterController {

	@Autowired
	EmployeeMasterService employeeMasterService;
	@Autowired
	UserService userService;
	@Autowired
	CompanyMasterService companyMasterService; 
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showEmployeeMaster(Model model) {
		List<EmployeeMasterEntity> empList = employeeMasterService.viewEmployeeMaster();
		model.addAttribute("empList",empList);
		return "admin/employee-master/view.jsp";
	}
	
	@RequestMapping(value="/create/form",method=RequestMethod.GET)
	public String showCreateEmployeeMasterForm(Model model) {
		List<UserEntity> users = userService.viewUser();
		model.addAttribute("users",users);
		return "admin/employee-master/create.jsp";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String AddEmployee(@RequestParam("Company_Id")int companyId, @RequestParam("User_Id")int userId) {
		EmployeeMasterEntity employeeMasterEntity = new EmployeeMasterEntity();
		employeeMasterEntity.setCompanyId(companyId);
		employeeMasterEntity.setUserId(userId);
		employeeMasterService.insertEmployeeMaster(employeeMasterEntity);
		return "redirect:/admin/employee-master";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteEmployeeMaster(Model model,@PathVariable("id") int id) {
		employeeMasterService.deleteEmployeeMaster(id);
		return "redirect:/admin/employee-master";
	}
}
