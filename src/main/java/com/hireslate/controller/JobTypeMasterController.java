package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.JobTypeMasterEntity;
import com.hireslate.service.JobTypeMasterService;

@Controller
@RequestMapping(value = "admin/job-type-master" , method = RequestMethod.GET)
public class JobTypeMasterController {
	
	@Autowired 
	JobTypeMasterService jobTypeMasterService;
	
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public String showJobTypeMaster(Model model) {
		List<JobTypeMasterEntity> jobType = jobTypeMasterService.viewJobTypeMaster();
	    model.addAttribute("jobType",jobType );
		return "admin/job-type-master/view.jsp";
	}
	
	@RequestMapping(value = "/create/form" , method = RequestMethod.GET)
	public String showCreateJobTypeMasterForm() {
		return "admin/job-type-master/create.jsp";
	}
	
	@RequestMapping(path="/create",method = RequestMethod.POST)
	public String addJobType (@RequestParam("jobTypeName") String name ){
		jobTypeMasterService.insertJobTypeMaster(name);
		return "redirect:/admin/job-type-master";
	}
	
	@RequestMapping(value  = "/edit/{id}", method = RequestMethod.GET)
	public String updateJobTypeMasterForm(Model model,@PathVariable("id") String id) {
		int jobTypeId = Integer.parseInt(id);
		JobTypeMasterEntity jobType = jobTypeMasterService.viewJobTypeMasterById(jobTypeId);
		model.addAttribute("jobTypeById", jobType);
		return "admin/job-type-master/update.jsp";
		
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String updateJobTypeMaster(Model model , @RequestParam(name = "jobTypeName") String name , @RequestParam("jobTypeId") String id) {
		int jobTypeId  = Integer.parseInt(id);
		JobTypeMasterEntity jobType = new JobTypeMasterEntity();
		jobType.setJobTypeId(jobTypeId);
		jobType.setJobTypeName(name);
		jobTypeMasterService.updateJobTypeMaster(jobType);
		return "redirect:/admin/job-type-master";
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteJobTypeMaster(Model model,@PathVariable("id") String id) {
		int jobTypeId = Integer.parseInt(id);
		jobTypeMasterService.deleteJobTypeMaster(jobTypeId);
		return "redirect:/admin/job-type-master";
	}


}
