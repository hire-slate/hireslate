package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.repository.JobMasterRepository;

public class JobMasterService {

	@Autowired
	JobMasterRepository jobMasterRepository;
	
	public List<JobMasterEntity> viewJobMaster(){
		return jobMasterRepository.view();
	}
	
	public void insertJobMaster(JobMasterEntity job) {
		jobMasterRepository.insert(job);
	}
	
	public void updateJobMaster(JobMasterEntity job) {
		jobMasterRepository.update(job);
	}
	
	public void deleteJobMaster(int id) {
		jobMasterRepository.delete(id);
	}
	
	public JobMasterEntity viewJobMasterById(int id) {
		return jobMasterRepository.viewById(id);
	}
}
