package com.hireslate.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.JobStagesEntity;

@Repository
public class JobStagesRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	public List<JobStagesEntity> view(){
		
		String sql = "Select * from job_stages";
		List <JobStagesEntity> jobStages = new ArrayList<JobStagesEntity>();
		List<Map<String,Object>> stages = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> stage : stages) {
			JobStagesEntity jobStage = new JobStagesEntity();
			jobStage.setStageName((String)stage.get("Stage_Name"));
			jobStage.setStageStartDate((Date)stage.get("Stage_StartDate"));
			jobStage.setStageEndDate((Date)stage.get("Stage_EndDate"));
			jobStage.setJobId((int)stage.get("Job_Id"));
			jobStage.setNextStage((int)stage.get("Next_Stage"));
			jobStages.add(jobStage);
		}
		return jobStages;
	}
	
	public void insert(JobStagesEntity jobStage) {
		
		String sql = "insert into INSERT INTO `job_stages`(`Stage_Name`, `Stage_StartDate`, `Stage_EndDate`, `Job_Id`, "
				+ "`Next_Stage`) VALUES ('"+jobStage.getStageName()+"','"+jobStage.getStageStartDate()+"','"+jobStage.getStageEndDate()+"',"+jobStage.getJobId()
				+")";
		jdbcTemplate.execute(sql);
	}
	
	public JobStagesEntity viewById(int id) {
		String sql = "select * from job_stages where Job_Stage_Id = "+id;
		Map<String,Object> jobStage = jdbcTemplate.queryForMap(sql);
		JobStagesEntity job = new JobStagesEntity();
		job.setStageName((String)jobStage.get("Stage_Name"));
		job.setStageStartDate((Date)jobStage.get("Stage_StartDate"));
		job.setStageEndDate((Date)jobStage.get("Stage_EndDate"));
		job.setJobId((int)jobStage.get("Job_Id"));
		job.setNextStage((int)jobStage.get("Next_Stage"));
		return job;
	}
	
	public void update(JobStagesEntity job) {
		
		String sql = "update job_stages set Stage_Name = '"+job.getStageName()+"', Stage_StartDate = '"+job.getStageStartDate()+"', Stage_EndDate='"+job.getStageEndDate()+"',"
				+ "Job_Id = "+job.getJobId()+", Next_Stage = "+job.getNextStage()+"where job_stages_id="+job.getJobStageId();
		jdbcTemplate.execute(sql);
	}
	
	public void delete(int id) {
		String sql = "delete from job_stages where Job_Stage_id = "+id;
		jdbcTemplate.execute(sql);
	}
}