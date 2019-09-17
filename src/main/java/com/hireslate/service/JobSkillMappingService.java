package com.hireslate.service;

import java.util.List;
import java.util.Map;

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
	
	public List<Map<String,Object>> searchJobBySKill(){
		return jobSkillMappingRepository.searchJobBySKill();
	}
}
