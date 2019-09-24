package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.repository.JobMasterRepository;

@Service
public class JobMasterService {

	@Autowired
	JobMasterRepository jobMasterRepository;
	
	public List<JobMasterEntity> viewJobMaster(){
		return jobMasterRepository.view();
	}
	
	public void insertJobMaster(JobMasterEntity job) {
		jobMasterRepository.insert(job);
	}
	
	public int insertJobMasterAndGetID(JobMasterEntity job) {
		return jobMasterRepository.insertAndGetId(job);
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
	
	public List<String> searchJobBySkill(String skill){
		return jobMasterRepository.jobSearch(skill);
	}
}
	