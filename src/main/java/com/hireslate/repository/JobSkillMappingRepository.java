package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobSkillMappingEntity;

@Repository
public class JobSkillMappingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	List<String> jobs = new ArrayList<String>();
	
	public void insert(JobSkillMappingEntity jobSkillMappingEntity) {
		String sql="INSERT INTO `job_skill_mapping`(`Job_Id`, `Skill_Id`, `Job_Skill_Priority`) VALUES "
				+ "("+jobSkillMappingEntity.getJobId()+","+jobSkillMappingEntity.getSkillId()+","+jobSkillMappingEntity.getJobSkillPriority()+")";
		jdbcTemplate.execute(sql);
	}
	
	
	public List<Map<String,Object>> searchJobBySKill(){
		String sql = "SELECT job_master.Job_Title from job_master WHERE job_master.Job_Id IN ( SELECT job_skill_mapping.Job_Id,skill_master.Skill_Name FROM job_skill_mapping,skill_master WHERE job_skill_mapping.Skill_Id = skill_master.Skill_Id)";
		List<Map<String,Object>> jobs = jdbcTemplate.queryForList(sql);
		
		return jobs;
	}
}
