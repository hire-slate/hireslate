package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CandidateSkillMappingEntity;
import com.hireslate.repository.CandidateSkillMappingRepository;

@Service
public class CandidateSkillMappingService {

	@Autowired
	CandidateSkillMappingRepository candidateSkillMappingRepository;
	
	public void insertCandidateSkillMapping(CandidateSkillMappingEntity candidateSkillMappingEntity) {
		candidateSkillMappingRepository.insert(candidateSkillMappingEntity);
	}
}
