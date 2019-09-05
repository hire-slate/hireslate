package com.hireslate.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.model.JobTypeMasterEntity;
import com.hireslate.model.SkillMasterEntity;


@Repository
public class JobMasterRepository {
	
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

	public void insert(JobMasterEntity job) {
		String sql = "insert into job_master Job_Title,Job_Salary,Job_Description,Job_Benefits,Job_Vacancy,Job_Opening_Date,Job_Closing_date,Job_Type_Id values ('"+job.getJobTitle()+"','"+job.getJobSalary()+"','"+job.getJobDescription()+"','"+job.getJobBenefits()+"','"+job.getJobVacancy()+"','"+job.getJobOpeningDate()+"','"+job.getJobClosingDate()+"','"+job.getJobTypeId()+"')";
		jdbcTemplate.execute(sql);
	}
	
	public void update(JobMasterEntity job) {
		String sql = "update job_master set Job_Title='"+job.getJobTitle()+"',Job_Salary='"+job.getJobSalary()+"',Job_Description='"+job.getJobDescription()+"',Job_Benefits='"+job.getJobBenefits()+"',Job_Vacancy='"+job.getJobVacancy()+"',Job_Opening_Date='"+job.getJobOpeningDate()+"',Job_Closing_date='"+job.getJobClosingDate()+"',Job_Type_Id='"+job.getJobTypeId()+"'";
		jdbcTemplate.execute(sql);
	}
	
    public void delete(int id) {
    	String sql = "delete from job_master where Job_Id="+id;
    	jdbcTemplate.execute(sql);
    }
    
    public JobMasterEntity viewById(int id) {
		String sql = "select * from job_master where Job_Id = "+ id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		JobMasterEntity job = new JobMasterEntity();
		job.setJobId((int)row.get("Job_Id"));
		job.setJobBenefits((String)row.get("Job_Benefits"));
		job.setJobClosingDate((Date)row.get("Job_Closing_Date"));
		job.setJobOpeningDate((Date)row.get("Job_Opening_Date"));
		job.setJobDescription((String)row.get("Job_Description"));
		job.setJobSalary((float)row.get("Job_Salary"));
		job.setJobTitle((String)row.get("Job_Title"));
		job.setJobVacancy((int)row.get("Job_Vacancy"));
		job.setJobTypeId((int)row.get("Job_Type_Id"));
		return job;
	}
}
