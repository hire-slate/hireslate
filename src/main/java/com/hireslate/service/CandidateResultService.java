package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.CandidateResultEntity;
import com.hireslate.repository.CandidateResultRepository;

@Service
public class CandidateResultService {

	@Autowired
	CandidateResultRepository candidateResultRepository;
	
	public List<CandidateResultEntity> viewCandidateResult(){
		return candidateResultRepository.view();
	}
	
	public CandidateResultEntity viewByIdCandidateResult(int id) {
		return candidateResultRepository.viewById(id);
	}
	
	public void insertCandidateResult(CandidateResultEntity candidateResult) {
		candidateResultRepository.insert(candidateResult);
	}
	
	public void updateCandidateResult(CandidateResultEntity candidateResult) {
		candidateResultRepository.update(candidateResult);
	}
	
	public void deleteCandidateResult(int id) {
		candidateResultRepository.delete(id);
	}
	
}
