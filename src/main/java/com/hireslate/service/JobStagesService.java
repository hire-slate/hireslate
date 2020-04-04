package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobStagesEntity;
import com.hireslate.repository.JobStagesRepository;

@Service
public class JobStagesService {

	@Autowired
	JobStagesRepository jobStagesRepository;
	
	public List<JobStagesEntity> viewJobStages(int jobId){
		return jobStagesRepository.viewByJobId(jobId);
	}
	
	public JobStagesEntity viewByIdJobStages(int id) {
		return  jobStagesRepository.viewById(id);
	}
	
	public void insertJobStages(JobStagesEntity jobStage) {
		jobStagesRepository.insert(jobStage);
	}
	
	public void updateJobStages(JobStagesEntity jobStage) {
		jobStagesRepository.update(jobStage);
	}
	
	public void deleteJobStages(int id) {
		jobStagesRepository.delete(id);
	}
}
