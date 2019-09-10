package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobTestEntity;

@Repository
public class JobTestRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(JobTestEntity jobTest) {
		
		String sql = "insert into job_test (`Company_Id`, `Job_Stage_Id`, `Total_Marks`, `Duration`) values ("
				+ jobTest.getCompanyId()+","+jobTest.getJobStageId()+","+jobTest.getTotalMarks()+","+jobTest.getDuration()+")";
		jdbcTemplate.execute(sql);
	}
}
