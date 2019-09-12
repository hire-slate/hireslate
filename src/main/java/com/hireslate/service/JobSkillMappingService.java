package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobSkillMappingEntity;
import com.hireslate.repository.JobSkillMappingRepository;

@Service
public class JobSkillMappingService{

	@Autowired
	JobSkillMappingRepository jobSkillMappingRepository;
	
	public void insertJobSkillMapping(JobSkillMappingEntity jobSkillMappingEntity) {
		jobSkillMappingRepository.insert(jobSkillMappingEntity);
	}
}
