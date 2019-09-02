package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.CourseMasterEntity;
import com.hireslate.service.CourseMasterService;

@Controller
@RequestMapping(value = "admin/course-master", method = RequestMethod.GET)
public class CourseMasterController {

	@Autowired
	CourseMasterService courseMasterService; 
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String showCourseMaster(Model model) {
		List<CourseMasterEntity> courses = courseMasterService.viewCourseMaster();
		model.addAttribute("course",courses);
		return "admin/course-master/view.jsp";
	}

	@RequestMapping(value="/create/form" , method = RequestMethod.GET)
	public String showCreateCourseMasterFrom() {
		return "admin/course-master/create.jsp";
	}
	
	@RequestMapping(path="/create",method = RequestMethod.POST)
	public String addCourse(@RequestParam("courseName") String name ){
		courseMasterService.insertCourseMaster(name);
		return "redirect:/admin/course-master";
	}
	
	@RequestMapping(value  = "/edit/{id}", method = RequestMethod.GET)
	public String updateCourseMasterForm(Model model,@PathVariable("id") String id) {
		int courseId = Integer.parseInt(id);	
		CourseMasterEntity course = courseMasterService.viewCourseMasterById(courseId);
		model.addAttribute("courseById", course);
		return "admin/course-master/update.jsp";
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String updateCourseMaster(Model model , @RequestParam(name = "courseName") String name , @RequestParam("courseId") String id) {
		int courseId  = Integer.parseInt(id);
		CourseMasterEntity course = new CourseMasterEntity();
		course.setCourseId(courseId);
		course.setCourseName(name);
		courseMasterService.updateCourseMaster(course);
		return "redirect:/admin/course-master";
	}
	

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteStreamMaster(Model model,@PathVariable("id") String id) {
		int courseId = Integer.parseInt(id);
		courseMasterService.deleteCourseMaster(courseId);
		return "redirect:/admin/course-master";
		
		
	}
}
