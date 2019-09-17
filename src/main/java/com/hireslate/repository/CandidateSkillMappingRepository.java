package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CandidateSkillMappingEntity;

@Repository
public class CandidateSkillMappingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(CandidateSkillMappingEntity candidateSkillMappingEntity) {
		
		String sql = "INSERT INTO `candidate_skill_mapping`(`User_Id`, `Skill_Id`, `Endorsed_Skill`) "
				+ "VALUES ("+candidateSkillMappingEntity.getUserId()+","+candidateSkillMappingEntity.getSkillId()+","+candidateSkillMappingEntity.getEndorsedSkill()+")";
		jdbcTemplate.execute(sql);
	}
}
