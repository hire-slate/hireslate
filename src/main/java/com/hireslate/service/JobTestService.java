package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobTestEntity;
import com.hireslate.repository.JobTestRepository;

@Service
public class JobTestService {

	@Autowired
	JobTestRepository jobTestRepository;
	
	public void insertJobTest(JobTestEntity jobTest) {
		jobTestRepository.insert(jobTest);
	}
}
