package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CourseMasterEntity;
import com.hireslate.repository.CourseMasterRepository;

@Service
public class CourseMasterService {

	@Autowired
	CourseMasterRepository courseMasterRepository;
	
	public List<CourseMasterEntity> viewCourseMaster(){
		return courseMasterRepository.view();
	}
	
	public void insertCourseMaster(String name) {
		courseMasterRepository.insert(name);
	}
	
	public CourseMasterEntity viewCourseMasterById(int id) {
		return courseMasterRepository.viewById(id);
	}
	
	public void updateCourseMaster(CourseMasterEntity course) {
		courseMasterRepository.update(course);
	}
	
	public void deleteCourseMaster(int id) {
		courseMasterRepository.delete(id);
	}
}
