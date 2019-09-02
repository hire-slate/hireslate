package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.SkillMasterEntity;
import com.hireslate.repository.SkillMasterRepository;

@Service
public class SkillMasterService {
	
	@Autowired
	SkillMasterRepository skillMasterRepository;
	
	public List<SkillMasterEntity> viewSkillMaster(){
		return skillMasterRepository.view();
	}
	
	public void insertSkillMaster(String name) {
		skillMasterRepository.insert(name);
	}
	
	public SkillMasterEntity viewSkillMasterById(int id) {
		return skillMasterRepository.viewById(id);
	}
	
	public void updateSkillMaster(SkillMasterEntity skill) {
		skillMasterRepository.update(skill);
	}
	
	public void deleteSkillMaster(int id) {
		skillMasterRepository.delete(id);
	}

}
