package com.hireslate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobTypeMasterEntity;


@Repository
public class JobTypeMasterController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	
	public JobTypeMasterController() {
		super();
	//	System.out.println("job type master created");
	}

	public List<JobTypeMasterEntity> view(){
		String sql = "SELECT * FROM job_type_master";
	
		List<JobTypeMasterEntity> jobs = new ArrayList<JobTypeMasterEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		System.out.println("hi");
		for(Map<String,Object> row : rows) {
			
			JobTypeMasterEntity job = new JobTypeMasterEntity();
			job.setJobTypeId((int)row.get("job_type_id"));
			job.setJobTypeName((String)row.get("Job_Type_Name"));
			jobs.add(job);
			System.out.println(jobs);
		}

		return jobs;
	}
	
	public void insert(String name) {
		String sql = "insert into job_type_master (job_type_name) values ('"+name+"')";
		jdbcTemplate.execute(sql);
		
	}
	
	public JobTypeMasterEntity viewById(int id) {
		String sql = "select * from job_type_master where job_type_id = "+ id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		JobTypeMasterEntity jobType = new JobTypeMasterEntity();
		
		jobType.setJobTypeId((int)row.get("job_type_id"));
		jobType.setJobTypeName((String)row.get("job_type_name"));
		return jobType;
	}
	
	public void update(JobTypeMasterEntity jobType) {
		String sql  = "update job_type_master set job_type_name =  '"+jobType.getJobTypeName()+"' where job_type_id = "+jobType.getJobTypeId();
		jdbcTemplate.execute(sql);
	}

	public void delete(int id) {
		String sql = "delete from job_type_master where job_type_id = "+id; 
		jdbcTemplate.execute(sql);
	}

}
