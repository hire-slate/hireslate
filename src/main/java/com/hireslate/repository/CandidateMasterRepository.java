package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CandidateMasterEntity;

@Repository
public class CandidateMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(CandidateMasterEntity candidate) {
		String sql="insert into candidate_master (User_Id,Candidate_Institute,Candidate_Course_StartYear,Candidate_University,Candidate_Course_EndYear,"
				+ "Course_Id,Stream_Id,Candidate_LinkedIn,Candidate_Github) values ("+
				candidate.getUserId()+",'"+candidate.getCandidateInstitute()+"',"+candidate.getCandidateCourseStartYear()+",'"+candidate.getCandidateUniversity()+"',"
				+candidate.getCandidateCourseEndYear()+","+candidate.getCourseId()+","+candidate.getStreamId()+",'"+candidate.getCandidateLinkedIn()+"','"
				+candidate.getCandidateGithub()+"')";                                                        
		jdbcTemplate.execute(sql);
	}
	
	public void update(CandidateMasterEntity candidate) {
		String sql = "update candidate_master set Candidate_Institute='"+candidate.getCandidateInstitute()+"', Candidate_Course_StartYear='"+candidate.getCandidateCourseStartYear()+"',Candidate_Course_EndYear='"+candidate.getCandidateCourseEndYear()+"',Course_Id='"+candidate.getCourseId()+"',Stream_Id='"+candidate.getStreamId()+"',Candidate_LinkedIn='"+candidate.getCandidateLinkedIn()+"',Candidate_Github='"+candidate.getCandidateGithub()+"' where Candidate_Id="+candidate.getCandidateMasterId()+"'";
		jdbcTemplate.execute(sql);
	}
	
	public void delete() {}
}
