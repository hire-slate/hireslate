package com.hireslate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.CourseMasterEntity;
import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.JobTypeMasterEntity;
import com.hireslate.model.SkillMasterEntity;
import com.hireslate.model.StreamMasterEntity;
import com.hireslate.repository.CourseMasterRepository;
import com.hireslate.repository.StreamMasterRepository;
import com.hireslate.service.JobSkillMappingService;

@Controller
public class DispatcherController {

	@Autowired
	public JobMasterController jobMasterController;
	@Autowired
	public JobSkillMappingService jobSkillMappingService;
	
	/*
	 * @RequestMapping(value = "user/index" , method = RequestMethod.GET) public
	 * String showIndex() { return "user/index.jsp"; }
	 */
	
	@RequestMapping(value = "user/homepage" , method = RequestMethod.GET)
	public String showhomepage(Model model) {
//		List<Map<String,Object>> jobs = jobSkillMappingService.searchJobBySKill();
	//	model.addAttribute("jobs", jobs);
		return "user/userhomepage.jsp";
	}
	
	@RequestMapping(value = "admin/dashboard", method = RequestMethod.GET)
	public String showDashboard() {
		return "admin/dashboard.jsp";
	}
	
	//skill-master table CRUD
	
//	@RequestMapping(value = "admin/skill-master", method = RequestMethod.GET)
//	public String showSkillMaster(Model model) {
//		List<SkillMasterEntity> skill = skillMasterController.view();
//		model.addAttribute("skill",skill);
//		return "admin/skill-master/view.jsp";
//	}
//	
//	@RequestMapping(value = "admin/skill-master/create/form" , method = RequestMethod.GET)
//	public String showCreateSkillMasterFrom() {
//		return "admin/skill-master/create.jsp";
//	}
//	
//	
//	@RequestMapping(path="admin/skill-master/create",method = RequestMethod.POST)
//	public String addSkill (@RequestParam("skillName") String name ){
//		skillMasterController.insert(name);
//	//	return "admin/skill-master/create.jsp";
//		return "redirect:/admin/skill-master";
//	}
//	
//	@RequestMapping(value  = "admin/skill-master/edit/{id}", method = RequestMethod.GET)
//	public String updateSkillMasterForm(Model model,@PathVariable("id") String id) {
//		int skillId = Integer.parseInt(id);
//		SkillMasterEntity skill = skillMasterController.viewById(skillId);
//		model.addAttribute("skillById", skill);
//		return "admin/skill-master/update.jsp";
//		
//	}
//	
//	@RequestMapping(value = "admin/skill-master/update" , method = RequestMethod.POST)
//	public String updateSkillMaster(Model model , @RequestParam(name = "skillName") String name , @RequestParam("skillId") String id) {
//		int skillId  = Integer.parseInt(id);
//		SkillMasterEntity skill = new SkillMasterEntity();
//		skill.setSkillId(skillId);
//		skill.setSkillName(name);
//		skillMasterController.update(skill);
//		return "redirect:/admin/skill-master";
//	}
//	
//	@RequestMapping(value="admin/skill-master/delete/{id}",method=RequestMethod.GET)
//	public String deleteSkillMaster(Model model,@PathVariable("id") String id) {
//		int skillId = Integer.parseInt(id);
//		skillMasterController.delete(skillId);
//		return "redirect:/admin/skill-master";
//	}
//	
	//Job-Master table CRUD
	
//	@RequestMapping(value = "admin/job-master", method = RequestMethod.GET)
//	public String showJobMaster(Model model) {
//		List<JobMasterEntity> job = jobMasterController.view();
//		model.addAttribute("job",job);
//		return "admin/job-master/view.jsp";
//	}
//	
//	@RequestMapping(value = "admin/job-master/create/form" , method = RequestMethod.GET)
//	public String showCreateJobMasterFrom() {
//		return "admin/job-master/create.jsp";
//	}
	
	
//	//Job-Type-Master table CRUD
//	
//	@RequestMapping(value = "admin/job-type-master" , method = RequestMethod.GET)
//	public String showJobTypeMaster(Model model) {
//		List<JobTypeMasterEntity> jobType = jobTypeMasterController.view();
//	    model.addAttribute("jobType",jobType );
//		return "admin/job-type-master/view.jsp";
//	}
//	
//	@RequestMapping(value = "admin/job-type-master/create/form" , method = RequestMethod.GET)
//	public String showCreateJobTypeMasterFrom() {
//		return "admin/job-type-master/create.jsp";
//	}
//	
//	@RequestMapping(path="admin/job-type-master/create",method = RequestMethod.POST)
//	public String addJobType (@RequestParam("jobTypeName") String name ){
//		jobTypeMasterController.insert(name);
//		return "redirect:/admin/job-type-master";
//	}
//	
//	@RequestMapping(value  = "admin/job-type-master/edit/{id}", method = RequestMethod.GET)
//	public String updateJobTypeMasterForm(Model model,@PathVariable("id") String id) {
//		int skillId = Integer.parseInt(id);
//		JobTypeMasterEntity jobType = jobTypeMasterController.viewById(skillId);
//		model.addAttribute("jobTypeById", jobType);
//		return "admin/job-type-master/update.jsp";
//		
//	}
//	
//	@RequestMapping(value = "admin/job-type-master/update" , method = RequestMethod.POST)
//	public String updateJobTypeMaster(Model model , @RequestParam(name = "jobTypeName") String name , @RequestParam("jobTypeId") String id) {
//		int jobTypeId  = Integer.parseInt(id);
//		JobTypeMasterEntity jobType = new JobTypeMasterEntity();
//		jobType.setJobTypeId(jobTypeId);
//		jobType.setJobTypeName(name);
//		jobTypeMasterController.update(jobType);
//		return "redirect:/admin/job-type-master";
//	}
//
//	@RequestMapping(value="admin/job-type-master/delete/{id}",method=RequestMethod.GET)
//	public String deleteJobTypeMaster(Model model,@PathVariable("id") String id) {
//		int jobTypeId = Integer.parseInt(id);
//		jobTypeMasterController.delete(jobTypeId);
//		return "redirect:/admin/job-type-master";
//	}
//	
//	
}
