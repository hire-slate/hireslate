package com.hireslate.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.JobTypeMasterEntity;


@Repository
public class JobMasterController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	
public List<JobMasterEntity> view(){
		
		String sql = "select * from job_master";
		List<JobMasterEntity> jobs = new ArrayList<JobMasterEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		for(Map<String,Object> row : rows) {
			
			JobMasterEntity job = new JobMasterEntity();
			job.setJobId((int)row.get("job_id"));
			job.setJobTitle((String)row.get("job_title"));
			job.setJobDescription((String)row.get("job_description"));
			job.setJobBenefits((String)row.get("job_benefits"));
			job.setJobVacancy((int)row.get("job_vacancy"));
			job.setJobOpeningDate((Date)row.get("job_opening_date"));
			job.setJobClosingDate((Date)row.get("job_closing_date"));
			job.setJobTypeId((int)row.get("job_type_id"));
			jobs.add(job);
			
		}
		
		return jobs;
	}

}
