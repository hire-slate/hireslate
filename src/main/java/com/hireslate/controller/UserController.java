package com.hireslate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hireslate.model.UserEntity;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired 
	UserService  userService;
	@Autowired
	JobMasterService jobMasterService;
	
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
	public String showIndex(HttpServletRequest request) {
		request.setAttribute("totalJobs",jobMasterService.totalJobs());
		return "user/index.jsp";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String doUserLogin(Model model,@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request) {
		String msg;
		UserEntity user = userService.doLogin(username, password);
		if(user != null) {
			request.getSession().setAttribute("userId", user.getUserId());
			request.getSession().setAttribute("userfname", user.getUserFname());
			request.getSession().setAttribute("userlname", user.getUserLname());
			msg = "redirect:/user/tryfrontend";  
		}
		else {
			model.addAttribute("message", "Invalid");
			msg = "redirect:/user/index";
		}
		return msg;
	}
	
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String doUserLogout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:/user/index";
	}

}
