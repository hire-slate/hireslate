package com.hireslate.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CandidateWorkExperienceEntity;

@Repository
public class CadidateWorkExperienceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CandidateWorkExperienceEntity> view(){
		
		String sql = "select * from candidate_work_experience";
		List<CandidateWorkExperienceEntity> work = new ArrayList<CandidateWorkExperienceEntity>();
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			CandidateWorkExperienceEntity candidateWork = new CandidateWorkExperienceEntity();
			
			candidateWork.setCandidateCompanyEndYear((Date)row.get("Candidate_Company_EndYear"));
			candidateWork.setCandidateCompanyStartYear((Date)row.get("Candidate_Company_StartYear"));
			candidateWork.setUserId((int)row.get("User_Id"));
			candidateWork.setCandidateCompanyName((String)row.get("Candidate_Company_Name"));
			candidateWork.setCandidateCurrentJob((int)row.get("Candidate_CurentJob"));
			candidateWork.setCandidateMasterId((int)row.get("Candidate_Master_Id"));
			candidateWork.setCandidateWorkTitle((String)row.get("Candidate_Work_Title"));
			work.add(candidateWork);
		}
		return work;
	}
	
	public void insert(CandidateWorkExperienceEntity work) {
		
		String sql = "insert into candidate_work_experience (User_Id,Candidate_Work_Title,Candidate_Company_Name,Candidate_Company_StartYear,"
				+ "Candidate_Company_EndYear,Candidate_CurentJob,Candidate_Master_Id) values ("+work.getUserId()+",'"+work.getCandidateWorkTitle()+"','"
						+ work.getCandidateCompanyName()+"','"+work.getCandidateCompanyStartYear()+"','"+work.getCandidateCompanyEndYear()+","
								+work.getCandidateCurrentJob()+","+work.getCandidateMasterId()+")";
		
		jdbcTemplate.execute(sql);
	}
	
	public void update(CandidateWorkExperienceEntity work) {
		
		String sql = "update candidate_work_experience set Candidate_Work_Title='"+work.getCandidateWorkTitle()+"', Candidate_Company_Name='"+work.getCandidateCompanyName()+"',"
				+work.getCandidateCompanyStartYear()+ "', Candidate_Company_EndYear='"+work.getCandidateCompanyEndYear()+"',Candidate_CurentJob="+work.getCandidateCurrentJob()
				+"where Candidate_Work_Id = "+work.getCandidateWorkExperienceId();
		jdbcTemplate.execute(sql);
	}
	
	public void delete(int id) {
		
		String sql = "delete from candidate_work_experience where Candidate_Work_Id = "+id;
		jdbcTemplate.execute(sql);
		
	}
	
	public CandidateWorkExperienceEntity viewById(int id) {
		
		String sql = "select * from candidate_work_experience where candidate_work_id = "+id;
		Map<String,Object> dbWork = jdbcTemplate.queryForMap(sql);
		
		CandidateWorkExperienceEntity work = new CandidateWorkExperienceEntity();
		work.setCandidateWorkTitle((String)dbWork.get("Candidate_Work_Title"));
		work.setCandidateCompanyName((String)dbWork.get("Candidate_Company_Name"));
		work.setCandidateCompanyStartYear((Date)dbWork.get("Candidate_Company_StartYear"));
		work.setCandidateCompanyEndYear((Date)dbWork.get("Candidate_Company_EndYear"));
		work.setCandidateCurrentJob((int)dbWork.get("Candidate_CurrentJob"));
		
		return work;
	}
	
}
