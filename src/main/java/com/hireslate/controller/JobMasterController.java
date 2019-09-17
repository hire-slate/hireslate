package com.hireslate.controller;

import java.text.SimpleDateFormat;
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
import com.hireslate.model.JobTypeMasterEntity;
import com.hireslate.model.SkillMasterEntity;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.JobSkillMappingService;
import com.hireslate.service.JobTypeMasterService;
import com.hireslate.service.SkillMasterService;

@Controller
@RequestMapping(value="admin/job-master")
public class JobMasterController {

	@Autowired
	JobMasterService jobMasterService;
	@Autowired
	JobTypeMasterService jobTypeMasterService;
	@Autowired 
	SkillMasterService skillMasterService;
	@Autowired
	JobSkillMappingService jobSkillMappingService;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showJobMaster(Model model) {
		List<JobMasterEntity> jobMaster = jobMasterService.viewJobMaster();
		model.addAttribute("jobMaster",jobMaster);
		return "admin/job-master/view.jsp";
	}
	
	@RequestMapping(value="/create/form",method=RequestMethod.GET)
	public String showCreateJobMasterForm(Model model) {
		List<JobTypeMasterEntity> jobTypes = jobTypeMasterService.viewJobTypeMaster();
		List<SkillMasterEntity> skills = skillMasterService.viewSkillMaster();
		model.addAttribute("jobType", jobTypes);
		model.addAttribute("skill",skills);
		return "admin/job-master/create.jsp";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String addJob(@RequestParam("jobTitle")String jobTitle,@RequestParam("jobSalary")float jobSalary,
			@RequestParam("jobDescription")String jobDescription,@RequestParam("jobBenefits")String jobBenefits,
			@RequestParam("jobVacancy")int jobVacancy,@RequestParam("jobOpeningDate")String jobOpeningDate,@RequestParam("jobClosingDate")String jobClosingDate,
			@RequestParam("jobTypeId")int jobTypeId,@RequestParam("jobSkills") int[] skills){
		
		JobMasterEntity job = new JobMasterEntity();
		job.setJobBenefits(jobBenefits);
		job.setJobDescription(jobDescription);
		job.setJobSalary(jobSalary);
		job.setJobTitle(jobTitle);
		job.setJobTypeId(jobTypeId);
		job.setJobVacancy(jobVacancy);
		job.setJobClosingDate(jobClosingDate);
		job.setJobOpeningDate(jobOpeningDate);
		int jobId = jobMasterService.insertJobMasterAndGetID(job);
		
		
		return "redirect:/admin/job-master";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String updateJobMasterForm(Model model, @PathVariable("id")int id) {
		JobMasterEntity jobEntity = jobMasterService.viewJobMasterById(id);
		model.addAttribute("jobEntity", jobEntity);
		return "admin/job-master/update.jsp";
		
	}
	
	@RequestMapping(value="/search" ,method=RequestMethod.GET)
	public void searchJobs(Model model,@RequestParam String skill) {
		List<String> jobs = jobMasterService.searchJobBySkill(skill);
		model.addAttribute("jobs",jobs);
	}
}
