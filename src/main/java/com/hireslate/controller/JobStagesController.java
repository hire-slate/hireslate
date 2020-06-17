package com.hireslate.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.JobStagesEntity;
import com.hireslate.service.JobMasterService;
import com.hireslate.service.JobStagesService;

@Controller
@RequestMapping(value="admin/job-steps")

public class JobStagesController{
	
	@Autowired
	JobStagesService jobStagesService;
	@Autowired
	JobMasterService jobMasterService;

	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showJobStages(Model model) {
		return "admin/job-stages/steps.jsp";
	}
	
	@RequestMapping(value="/create/form/{id}",method=RequestMethod.GET)
	public String showCreateJobStepForm(Model model,@PathVariable("id")int id) {
		model.addAttribute("jobId",id);
		JobMasterEntity jobMasterEntity = new JobMasterEntity();
		List<JobStagesEntity> jobStages = jobStagesService.viewJobStages(id);
		jobMasterEntity = jobMasterService.viewJobMasterById(id);
		model.addAttribute("jobName", jobMasterEntity.getJobTitle());
		model.addAttribute("jobStages",jobStages);
		model.addAttribute("jobOpeningDate",jobMasterEntity.getJobOpeningDate());
		model.addAttribute("jobClosingDate",jobMasterEntity.getJobClosingDate());
		return "admin/job-stages/create.jsp";
	}
	
	@RequestMapping(value="create/{id}",method=RequestMethod.POST)
	public String createJobStep(Model model,@PathVariable("id")int id,@RequestParam( "submit")String submit,@RequestParam("jobStepName")String jobStageName,
			@RequestParam("jobStepDates")Object jobStageDateRange) {
		String msg = "";
		JobStagesEntity jobStagesEntity = new JobStagesEntity();
		
		JobMasterEntity jobMasterEntity = new JobMasterEntity();
		jobMasterEntity = jobMasterService.viewJobMasterById(id);
		model.addAttribute("jobName", jobMasterEntity.getJobTitle());
		model.addAttribute("jobOpeningDate",jobMasterEntity.getJobOpeningDate());
		model.addAttribute("jobClosingDate",jobMasterEntity.getJobClosingDate());
		if(submit.equals("save")) {
			String jobStageDate = (String)jobStageDateRange;
			String[] jobStageDates = jobStageDate.split(" - ");
			Date jobStageOpening	= Date.valueOf(jobStageDates[0]);
			Date jobStageClosing	= Date.valueOf(jobStageDates[1]);
			jobStagesEntity.setJobId(id);
			jobStagesEntity.setStageName(jobStageName);
			jobStagesEntity.setStageStartDate(jobStageOpening);
			jobStagesEntity.setStageEndDate(jobStageClosing);
			jobStagesService.insertJobStages(jobStagesEntity);
			model.addAttribute("jobId",id);
			List<JobStagesEntity> jobStages = jobStagesService.viewJobStages(id);
			model.addAttribute("jobStages",jobStages);
			msg = "admin/job-stages/create.jsp";
		}
		else {
			String jobStageDate = (String)jobStageDateRange;
			String[] jobStageDates = jobStageDate.split(" - ");
			Date jobStageOpening	= Date.valueOf(jobStageDates[0]);
			Date jobStageClosing	= Date.valueOf(jobStageDates[1]);
			jobStagesEntity.setJobId(id);
			jobStagesEntity.setStageName(jobStageName);
			jobStagesEntity.setStageStartDate(jobStageOpening);
			jobStagesEntity.setStageEndDate(jobStageClosing);
			jobStagesService.insertJobStages(jobStagesEntity);
			msg = "redirect:/admin/dashboard"; 
		}
		return msg;
	}
}