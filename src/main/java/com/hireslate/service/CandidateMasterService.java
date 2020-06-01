package com.hireslate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CandidateMasterEntity;
import com.hireslate.repository.CandidateMasterRepository;

@Service
public class CandidateMasterService {

	@Autowired
	CandidateMasterRepository candidateMasterRepository;
	
	public void insertCandidateMaster(CandidateMasterEntity candidateMasterEntity) {
		candidateMasterRepository.insert(candidateMasterEntity);
	}
	
	public void updateCandidateMaster(CandidateMasterEntity candidateMasterEntity) {
		candidateMasterRepository.update(candidateMasterEntity);
	}
	
	public CandidateMasterEntity getCandidate(int userId) {
		return candidateMasterRepository.getCandidate(userId);
	}
}