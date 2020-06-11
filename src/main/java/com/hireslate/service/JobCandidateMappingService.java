package com.hireslate.service;

import java.util.List;
import java.util.Map;

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
	
	public List<Map<String, Object>> viewAppliedApplicantd(int jobId) {
		return jobCandidateMappingRepository.viewCandidatesForJob(jobId);
	}
}
