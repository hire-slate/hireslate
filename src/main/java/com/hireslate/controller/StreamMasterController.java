package com.hireslate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hireslate.model.StreamMasterEntity;
import com.hireslate.service.StreamMasterService;

@Controller 
@RequestMapping(value="admin/stream-master" , method=RequestMethod.GET)
public class StreamMasterController {
	
	@Autowired 
	StreamMasterService streamMasterService;

	@RequestMapping(value="",method = RequestMethod.GET)
	public String showStreamMaster(Model model) {
		List<StreamMasterEntity> streams = streamMasterService.viewStreamMaster();
		model.addAttribute("stream",streams);
		return "admin/stream-master/view.jsp";
	}
	
	@RequestMapping(value = "/create/form" , method = RequestMethod.GET)
	public String showCreateStreamMasterFrom() {
		return "admin/stream-master/create.jsp";
	}
	
	
	@RequestMapping(path="/create",method = RequestMethod.POST)
	public String addStream(@RequestParam("streamName") String name,@RequestParam("courseId") int id ){
		streamMasterService.insertStreamMaster(name,id);
		return "redirect:/admin/stream-master";
	}
	
	@RequestMapping(value  = "/edit/{id}", method = RequestMethod.GET)
	public String updateStreamMasterForm(Model model,@PathVariable("id") String id) {
		int streamId = Integer.parseInt(id);
		StreamMasterEntity stream = streamMasterService.viewStreamMasterById(streamId);
		model.addAttribute("streamById", stream);
		return "admin/stream-master/update.jsp";
		
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public String updateStreamMaster(Model model , @RequestParam(name = "streamName") String name , @RequestParam("courseId") String courseId,@RequestParam("streamId") String streamId) {
		StreamMasterEntity stream = new StreamMasterEntity();
		stream.setStreamId(Integer.parseInt(streamId));
		stream.setStreamName(name);
		stream.setCourseId(Integer.parseInt(courseId));
		streamMasterService.updateStreamMaster(stream);
		return "redirect:/admin/stream-master";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteStreamMaster(Model model,@PathVariable("id") String id) {
		int streamId = Integer.parseInt(id);
		streamMasterService.deleteStreamMaster(streamId);
		return "redirect:/admin/stream-master";
		
	}

	
	
}
