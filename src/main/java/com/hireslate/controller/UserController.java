package com.hireslate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired 
	UserService  userService;
	
	
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
	public String showIndex() {
		return "user/index.jsp";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String doUserLogin(Model model,@RequestParam("username") String username, @RequestParam("password") String password ) {
		String msg;
		int loginResult = userService.doLogin(username, password);
		if(loginResult != -1) {
			msg = "redirect:/user/homepage";  
		}
		else {
			msg = "redirect:/user/index";
		}
		return msg;
	}

}
