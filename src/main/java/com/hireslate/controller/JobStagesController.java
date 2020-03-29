package com.hireslate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hireslate.model.JobMasterEntity;

@Controller
@RequestMapping(value="admin/job-steps")
public class JobStagesController{
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showJobStages(Model model) {
		//List<JobMasterEntity> jobMaster = jobMasterService.viewJobMaster();
		//model.addAttribute("jobMaster",jobMaster);
		return "/job-stages/steps.jsp";
	}
	
	@RequestMapping(value="/create/form",method=RequestMethod.GET)
	public String showCreateJobMasterForm(Model model) {
		return "admin/job-stages/create.jsp";
	}
}