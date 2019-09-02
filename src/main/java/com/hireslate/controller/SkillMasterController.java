package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.SkillMasterEntity;
import com.hireslate.service.SkillMasterService;

@Controller
@RequestMapping(value="admin/skill-master",method = RequestMethod.GET)
public class SkillMasterController {
	
	@Autowired
	SkillMasterService skillMasterService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showSkillMaster(Model model) {
		List<SkillMasterEntity> skillMasterEntity = skillMasterService.viewSkillMaster();
		model.addAttribute("skillMasterEntity",skillMasterEntity);
		return "admin/skill-master/view.jsp";
	}
	
	@RequestMapping(value="/create/form",method=RequestMethod.GET)
	public String showCreateSkillMasterForm() {
		return "admin/skill-master/create.jsp";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String addSkill(@RequestParam("skillName")String skillName) {
		skillMasterService.insertSkillMaster(skillName);
		return "redirect:/admin/skill-master";
	}
	
	@RequestMapping(value="/edit{id}",method=RequestMethod.GET)
	public String updateSkillMasterForm(Model model,@PathVariable("id") String id ) {
		int skillId = Integer.parseInt(id);	
		SkillMasterEntity skillEntity = skillMasterService.viewSkillMasterById(skillId);
		model.addAttribute("skillById", skillEntity);
		return "admin/skill-master/update.jsp";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateSkillMaster(@RequestParam("skillName")String skillName ,@RequestParam("skillId")String id) {
		int skillId  = Integer.parseInt(id);
		SkillMasterEntity skillEntity = new SkillMasterEntity();
		skillEntity.setSkillId(skillId);
		skillEntity.setSkillName(skillName);
		skillMasterService.updateSkillMaster(skillEntity);
		return "redirect:/admin/skill-master";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteSkillMaster(Model model,@PathVariable("id") String id) {
		int skillId = Integer.parseInt(id);
		skillMasterService.deleteSkillMaster(skillId);
		return "redirect:admin/skill-master";
	}
}
