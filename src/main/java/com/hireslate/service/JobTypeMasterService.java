package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobTypeMasterEntity;
import com.hireslate.repository.JobTypeMasterRepository;

@Service
public class JobTypeMasterService {

	@Autowired
	JobTypeMasterRepository jobTypeMasterRepository;
	
	public List<JobTypeMasterEntity> viewJobTypeMaster(){
		return jobTypeMasterRepository.view();
	}
	
	public void insertJobTypeMaster(String name) {
		jobTypeMasterRepository.insert(name);
	}
	
	public JobTypeMasterEntity viewJobTypeMasterById(int id) {
		return jobTypeMasterRepository.viewById(id);
	}
	
	public void updateJobTypeMaster(JobTypeMasterEntity jobType) {
		jobTypeMasterRepository.update(jobType);
	}
	
	public void deleteJobTypeMaster(int id) {
		jobTypeMasterRepository.delete(id);
	}
}
