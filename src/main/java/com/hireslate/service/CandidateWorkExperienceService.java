package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CandidateWorkExperienceEntity;
import com.hireslate.repository.CadidateWorkExperienceRepository;

@Service
public class CandidateWorkExperienceService {
	
	@Autowired
	CadidateWorkExperienceRepository candidateWorkExperienceRepository;
	
	public List<CandidateWorkExperienceEntity> viewCandidateWorkExperience(){
		return candidateWorkExperienceRepository.view();
	}
	
	public void insertCandidateWorkExperience(CandidateWorkExperienceEntity work) {
		candidateWorkExperienceRepository.insert(work);
	}
	
	public void updateCadidateWorkExperience(CandidateWorkExperienceEntity work) {
		candidateWorkExperienceRepository.update(work);
	}
	
	public void deleteCadidateWorkExperience(int id) {
		candidateWorkExperienceRepository.delete(id);
	}
}
