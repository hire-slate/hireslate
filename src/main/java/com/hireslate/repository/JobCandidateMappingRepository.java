package com.hireslate.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobCandidateMappingEntity;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Map<String,Object>> viewCandidatesForJob(int jobId){
		String sql = "SELECT user.User_Id ,user.User_Fname, user.User_Lname, user.User_City, user.User_State ,candidate_master.Candidate_Institute, candidate_master.Candidate_University, "
				+ "candidate_master.Candidate_LinkedIn, candidate_master.Candidate_Github, candidate_master.Candidate_Course_EndYear, "
				+ "course_master.Course_Name, stream_master.Stream_Name " 
				+ "FROM user, job_candidate_mapping, candidate_master, course_master, stream_master WHERE " 
				+ "candidate_master.Course_Id = course_master.Course_Id AND "
				+ "candidate_master.Stream_Id = stream_master.Stream_Id AND " 
				+ "user.User_Id = job_candidate_mapping.User_Id AND " 
				+ "candidate_master.User_Id = job_candidate_mapping.User_Id "
				+ "AND job_candidate_mapping.Job_Id = "+jobId;
		List<Map<String, Object>> candidates = new ArrayList<Map<String, Object>>();
		candidates = jdbcTemplate.queryForList(sql); 
		return candidates;
	}
}
