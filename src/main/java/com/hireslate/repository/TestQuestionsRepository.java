package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.TestQuestionsEntity;

@Repository
public class TestQuestionsRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<TestQuestionsEntity> view(int jobId, int skillId){
		String sql = "select * from test_questions where Job_Id = "+jobId+" AND Skill_Id = "+skillId;
		
		List<TestQuestionsEntity> testQuestions = new ArrayList<TestQuestionsEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			TestQuestionsEntity test = new TestQuestionsEntity();
			
			test.setJobTestId((int)row.get("Test_Question_Id"));
			test.setTestQuestion((String)row.get("Test_Question"));
			test.setTestAnswerOption1((String)row.get("Test_Answer_Option1"));
			test.setTestAnswerOption2((String)row.get("Test_Answer_Option2"));
			test.setTestAnswerOption3((String)row.get("Test_Answer_Option3"));
			test.setTestAnswerOption4((String)row.get("Test_Answer_Option4"));
			test.setTestRightAnswer((int)row.get("Test_Right_Answer"));
			test.setTestImage((String)row.get("Test_Image"));
			testQuestions.add(test);
		}
		return testQuestions;
	}
	
	// Dont know where to use Dx
	public TestQuestionsEntity viewById(int id) {
		String sql = "select * from test_questions where Test_Question_Id = "+id;
		TestQuestionsEntity test = new TestQuestionsEntity();
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		test.setJobTestId((int)row.get("Job_Test_Id"));
		test.setTestQuestionsId((int)row.get("Test_Questions_Id"));
		test.setTestQuestion((String)row.get("Test_Question"));
		test.setTestAnswerOption1((String)row.get("Test_Answer_Option1"));
		test.setTestAnswerOption2((String)row.get("Test_Answer_Option2"));
		test.setTestAnswerOption3((String)row.get("Test_Answer_Option3"));
		test.setTestAnswerOption4((String)row.get("Test_Answer_Option4"));
		test.setTestRightAnswer((int)row.get("Test_Right_Answer"));
		test.setTestImage((String)row.get("Test_Image"));
		test.setSkillId((int)row.get("Skill_Id"));
		return test;
	}
	
	public void insert(TestQuestionsEntity test) {
		String sql ="insert INSERT INTO `test_questions`( `Test_Question`, `Test_Answer_Option1`, `Test_Answer_Option2`, "
				+ "`Test_Answer_Option3`, `Test_Answer_Option4`, `Test_Right_Answer`, `Test_Image`, `Job_Test_Id`, `Skill_Id`) VALUES ('"+test.getTestQuestion()+"','"
						+ test.getTestAnswerOption1()+"','"+test.getTestAnswerOption2()+"','"+test.getTestAnswerOption3()+"','"+test.getTestAnswerOption4()+"',"
								+test.getTestRightAnswer()+",'"+test.getTestImage()+"',"+test.getJobTestId()+","+test.getSkillId()+")";
		jdbcTemplate.execute(sql);
	}
	
	public void update(TestQuestionsEntity test) {
		String sql = "UPDATE `test_questions` SET `Test_Question`='"+test.getTestQuestion()+"',`Test_Answer_Option1`='"+test.getTestAnswerOption1()+"',"
				+ "`Test_Answer_Option2`='"+test.getTestAnswerOption2()+"',`Test_Answer_Option3`='"+test.getTestAnswerOption3()+"',`Test_Answer_Option4`='"+test.getTestAnswerOption4()+"',"
				+ "`Test_Right_Answer`="+test.getTestRightAnswer()+",`Test_Image`='"+test.getTestImage()+"',`Job_Test_Id`="+test.getJobTestId()+","
				+ "`Skill_Id`="+test.getSkillId()+" WHERE Test_Question_Id="+test.getTestQuestionsId();
		jdbcTemplate.execute(sql);
	}
	
	public void delete(int id) {
		String sql = "delete test_questions where Test_Questions_Id="+id;
		jdbcTemplate.execute(sql);
	}
}
