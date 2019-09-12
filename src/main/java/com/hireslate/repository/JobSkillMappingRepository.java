package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobSkillMappingEntity;

@Repository
public class JobSkillMappingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(JobSkillMappingEntity jobSkillMappingEntity) {
		String sql="INSERT INTO `job_skill_mapping`(`Job_Id`, `Skill_Id`, `Job_Skill_Priority`) VALUES "
				+ "("+jobSkillMappingEntity.getJobId()+","+jobSkillMappingEntity.getSkillId()+","+jobSkillMappingEntity.getJobSkillPriority()+")";
		jdbcTemplate.execute(sql);
	}
	
}
