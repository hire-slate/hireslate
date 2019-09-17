package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CandidateResultEntity;

@Repository
public class CandidateResultRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<CandidateResultEntity> view(){
		String sql = "SELECT * FROM `candidate_result`";
		List<CandidateResultEntity> candidateResult = new ArrayList<CandidateResultEntity>();
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			CandidateResultEntity result = new CandidateResultEntity();
			result.setCandidateResultId((int)row.get("Candidate_Result_Id"));
			result.setCandidateMasterId((int)row.get("Candidate_Master_Id"));
			result.setJobId((int)row.get("Job_Id"));
			result.setJobTestId((int)row.get("Job_Test_Id"));
			result.setObtainedMarks((int)row.get("Obtained_Marks"));
			result.setTotalMarks((int)row.get("Total_Marks"));
			result.setRemarks((String)row.get("Remarks"));
			result.setEmployeeId((int)row.get("Employee_Id"));
			candidateResult.add(result);
		}
		return candidateResult;
	}
	
	public CandidateResultEntity viewById(int id) {
		String sql = "SELECT * FROM `candidate_result` WHERE Candidate_Result_Id="+id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		CandidateResultEntity candidateResult = new CandidateResultEntity();
		candidateResult.setCandidateMasterId((int)row.get("Candidate_Result_Id"));
		candidateResult.setCandidateMasterId((int)row.get("Candidate_Master_Id"));
		candidateResult.setJobId((int)row.get("Job_Id"));
		candidateResult.setJobTestId((int)row.get("Job_Test_Id"));
		candidateResult.setObtainedMarks((int)row.get("Obtained_Marks"));
		candidateResult.setTotalMarks((int)row.get("Total_Marks"));
		candidateResult.setRemarks((String)row.get("Remarks"));
		candidateResult.setEmployeeId((int)row.get("Employee_Id"));
		return candidateResult;
	}
	
	public void insert(CandidateResultEntity candidateResult) {
		String sql = "INSERT INTO `candidate_result`(`Candidate_Master_Id`, `Job_Id`, `Job_Test_Id`, `Obtained_Marks`, "
				+ "`Total_Marks`, `Remarks`, `Employee_Id`) VALUES ("+candidateResult.getCandidateMasterId()+","+candidateResult.getJobId()+","
				+candidateResult.getJobTestId()+","+candidateResult.getObtainedMarks()+","+candidateResult.getTotalMarks()+",'"+candidateResult.getRemarks()+"',"
						+candidateResult.getEmployeeId()+")";
		jdbcTemplate.execute(sql);
	}
	
	public void update(CandidateResultEntity candidateResult) {
		String sql ="UPDATE `candidate_result` SET `Candidate_Master_Id`="+candidateResult.getCandidateMasterId()+",`Job_Id`="+candidateResult.getJobId()+","
				+ "`Job_Test_Id`="+candidateResult.getJobTestId()+",`Obtained_Marks`="+candidateResult.getObtainedMarks()+",`Total_Marks`="+candidateResult.getTotalMarks()+","
				+ "`Remarks`='"+candidateResult.getRemarks()+"',`Employee_Id`="+candidateResult.getEmployeeId()+" WHERE `Candidate_Result_Id`="+candidateResult.getCandidateResultId();
		jdbcTemplate.execute(sql);
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM `candidate_result` WHERE Candidate_Result_Id="+id;
		jdbcTemplate.execute(sql);
	}
}
