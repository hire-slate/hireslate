package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hireslate.model.TestQuestionsEntity;
import com.hireslate.service.TestQuestionsService;

@Controller
@RequestMapping(value = "test", method = RequestMethod.GET)
public class TestController {
	
	@Autowired
	TestQuestionsService testService; 
		
	@RequestMapping(value="",method=RequestMethod.GET)
	public String startTest(Model model) {
		List<TestQuestionsEntity> testQuestions = testService.viewTestQuestions(3, 3);
		model.addAttribute("testQuestions", testQuestions);
		return "user/test.jsp";
	}

}
