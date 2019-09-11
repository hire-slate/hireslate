package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.TestQuestionsEntity;
import com.hireslate.repository.TestQuestionsRepository;

@Service
public class TestQuestionsService {

	@Autowired
	TestQuestionsRepository testQuestionsRepository; 
	
	public List<TestQuestionsEntity> viewTestQuestions(){
		return testQuestionsRepository.view();
	}
	
	public TestQuestionsEntity viewByIdTestQuestions(int id) {
		return testQuestionsRepository.viewById(id);
	}
	
	public void insertTestQuestions(TestQuestionsEntity test) {
		testQuestionsRepository.insert(test);
	}
	
	public void updateTestQuestions(TestQuestionsEntity test) {
		testQuestionsRepository.update(test);
	}
	
	public void deleteTestQuestions(int id) {
		testQuestionsRepository.delete(id);
	}
		
}
