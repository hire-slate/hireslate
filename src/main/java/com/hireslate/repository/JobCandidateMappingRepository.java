package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobCandidateMappingEntity;

@Repository
public class JobCandidateMappingRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(JobCandidateMappingEntity jobCandidateMappingEntity) {
	String sql = "INSERT INTO `job_candidate_mapping`(`Job_Id`, `User_Id`, `Job_Current_Stage`, `Job_Current_Salary`, "
				+ "`Job_Expected_Salary`, `Job_Change_Reason`) VALUES ("+jobCandidateMappingEntity.getJobId()+","+jobCandidateMappingEntity.getUserId()+","
						+jobCandidateMappingEntity.getJobCurrentStage()+","+jobCandidateMappingEntity.getJobCurrentSalary()+","+jobCandidateMappingEntity.getJobExpectedSalary()+
						",'"+jobCandidateMappingEntity.getJobChangeReason()+"')";
		
		jdbcTemplate.execute(sql);
	}
}
