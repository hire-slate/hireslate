package com.hireslate.repository;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
			job.setJobSalary((float)row.get("job_salary"));
			jobs.add(job);
		}
		return jobs;
	}

	public void insert(JobMasterEntity job) {
		String sql = "insert into job_master (Job_Title,Job_Salary,Job_Description,Job_Benefits,Job_Vacancy,Job_Opening_Date,Job_Closing_date,Job_Type_Id,Company_Id) values ('"
				+job.getJobTitle()+"',"+job.getJobSalary()+",'"+job.getJobDescription()+"','"+job.getJobBenefits()+"',"+job.getJobVacancy()+",'"
				+job.getJobOpeningDate()+"','"+job.getJobClosingDate()+"',"+job.getJobTypeId()+","+job.getJobCompanyId()+")";
		jdbcTemplate.execute(sql);
	}	
	
	public void update(JobMasterEntity job) {
		String sql = "update job_master set Job_Title='"+job.getJobTitle()+"',Job_Salary="+job.getJobSalary()+",Job_Description='"
				+job.getJobDescription()+"',Job_Benefits='"+job.getJobBenefits()+"',Job_Vacancy="+job.getJobVacancy()+",Job_Opening_Date='"
				+job.getJobOpeningDate()+"',Job_Closing_date='"+job.getJobClosingDate()+"',Job_Type_Id="+job.getJobTypeId()+
				" where Job_Id ="+job.getJobId();
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
		job.setJobOpeningDate((Date)row.get("Job_Opening_Date"));
		job.setJobClosingDate((Date)row.get("Job_Closing_Date"));
		job.setJobDescription((String)row.get("Job_Description"));
		job.setJobSalary((float)row.get("Job_Salary"));
		job.setJobTitle((String)row.get("Job_Title"));
		job.setJobVacancy((int)row.get("Job_Vacancy"));
		job.setJobTypeId((int)row.get("Job_Type_Id"));
		return job;
	}
    
    public int insertAndGetId(JobMasterEntity job) {
		String sql = "insert into job_master (Job_Title,Job_Salary,Job_Description,Job_Benefits,Job_Vacancy,Job_Opening_Date,Job_Closing_date,Job_Type_Id,Company_Id) values ('"
				+job.getJobTitle()+"',"+job.getJobSalary()+",'"+job.getJobDescription()+"','"+job.getJobBenefits()+"',"+job.getJobVacancy()+",'"
				+job.getJobOpeningDate()+"','"+job.getJobClosingDate()+"',"+job.getJobTypeId()+","+job.getJobCompanyId()+")";
		jdbcTemplate.execute(sql);
		String sql1 = "select job_id from job_master order by job_id desc limit 1";
		Map<String,Object> row = jdbcTemplate.queryForMap(sql1);
		int jobId = (int)row.get("Job_Id");
		return jobId;
	}
    
    public List<String> jobSearch(String skill){
    	String sql = "SELECT job_master.Job_Title FROM job_master WHERE job_master.Job_Id IN(SELECT job_skill_mapping.Job_Id FROM job_skill_mapping WHERE job_skill_mapping.Skill_Id IN (SELECT skill_master.Skill_Id FROM skill_master WHERE skill_master.Skill_Name like '"+skill+"%'))";
    	List<String> jobs = new ArrayList<String>();
    	List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
    	for(Map<String,Object> row : rows) {
    		jobs.add((String)row.get("Job_Title"));
    	}
    	return jobs;
    }

	public List<List> jobSearchByCompany(String companyId) {
		String sql = "SELECT job_master.Job_Title, job_type_master.Job_Type_Name , job_master.Job_Vacancy,job_master.Job_Closing_date from job_master INNER join job_type_master ON job_master.Job_Type_Id = job_type_master.Job_Type_Id WHERE job_master.Company_Id = "+companyId+" AND\r\n" + 
				"job_master.Job_Closing_date > CURRENT_DATE() ";
		
		List<String> jobObject = new ArrayList<String>();
		List<List> jobs = new ArrayList<List>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		for(Map<String, Object> row : rows) {
			jobObject.add((String)row.get("Job_Title"));
			jobObject.add((String)row.get("Job_Type_Name"));
			jobObject.add(String.valueOf(row.get("Job_Vacancy")));
			jobObject.add(df.format(row.get("Job_Closing_Date")));
			jobs.add(jobObject);
		}
		return jobs;
	}
	
}
