package com.hireslate.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.SkillMasterEntity;
import com.hireslate.service.JobMasterService;

@Controller
@RequestMapping(value="admin/job-master")
public class JobMasterController {

	@Autowired
	JobMasterService jobMasterService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showJobMaster(Model model) {
		List<JobMasterEntity> jobMaster = jobMasterService.viewJobMaster();
		model.addAttribute("jobMaster",jobMaster);
		return "admin/job-master/view.jsp";
	}
	
	@RequestMapping(value="/create/form",method=RequestMethod.GET)
	public String showCreateJobMasterForm() {
		return "admin/job-master/create.jsp";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String addJob(@RequestParam("jobTitle")String jobTitle,@RequestParam("jobSalary")float jobSalary,@RequestParam("jobDescription")String jobDescription,@RequestParam("jobBenefits")String jobBenefits,@RequestParam("jobVacancy")int jobVacancy,@RequestParam("jobOpeningDate")Date jobOpeningDate,@RequestParam("jobClosingDate")Date jobClosingDate,@RequestParam("jobTypeId")int jobTypeId){
		JobMasterEntity job = new JobMasterEntity();
		job.setJobBenefits(jobBenefits);
		job.setJobClosingDate(jobClosingDate);
		job.setJobDescription(jobDescription);
		job.setJobOpeningDate(jobOpeningDate);
		job.setJobSalary(jobSalary);
		job.setJobTitle(jobTitle);
		job.setJobTypeId(jobTypeId);
		job.setJobVacancy(jobVacancy);
		jobMasterService.insertJobMaster(job);
		return "redirect:admin/job-master";
	}
	
	@RequestMapping(value="/edit{id}",method=RequestMethod.GET)
	public String updateJobMasterForm(Model model, @PathVariable("id")int id) {
		JobMasterEntity jobEntity = jobMasterService.viewJobMasterById(id);
		model.addAttribute("jobEntity", jobEntity);
		return "admin/job-master/update.jsp";
		
	}
	
}
