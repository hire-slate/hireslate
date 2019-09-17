package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobCandidateMappingEntity;
import com.hireslate.repository.JobCandidateMappingRepository;

@Service
public class JobCandidateMappingService {

	@Autowired
	JobCandidateMappingRepository jobCandidateMappingRepository;
	
	public void insert(JobCandidateMappingEntity jobCandidateMappingEntity) {
	
		jobCandidateMappingRepository.insert(jobCandidateMappingEntity);
	}
}
