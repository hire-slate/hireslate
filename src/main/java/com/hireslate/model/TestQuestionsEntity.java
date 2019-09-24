package com.hireslate.model;

public class TestQuestionsEntity {

	private int testQuestionsId, testRightAnswer, jobTestId, skillId;
	private String testQuestion, testAnswerOption1, testAnswerOption2, testAnswerOption3, testAnswerOption4, testImage;

	public TestQuestionsEntity() {
	}

	public TestQuestionsEntity(int testRightAnswer, int jobTestId, int skillId, String testQuestion,
			String testAnswerOption1, String testAnswerOption2, String testAnswerOption3, String testAnswerOption4,
			String testImage) {
		super();
		//this.testQuestionsId = testQuestionsId;
		this.testRightAnswer = testRightAnswer;
		this.jobTestId = jobTestId;
		this.skillId = skillId;
		this.testQuestion = testQuestion;
		this.testAnswerOption1 = testAnswerOption1;
		this.testAnswerOption2 = testAnswerOption2;
		this.testAnswerOption3 = testAnswerOption3;
		this.testAnswerOption4 = testAnswerOption4;
		this.testImage = testImage;
	}

	public int getTestQuestionsId() {
		return testQuestionsId;
	}

	public void setTestQuestionsId(int testQuestionsId) {
		this.testQuestionsId = testQuestionsId;
	}

	public int getTestRightAnswer() {
		return testRightAnswer;
	}

	public void setTestRightAnswer(int testRightAnswer) {
		this.testRightAnswer = testRightAnswer;
	}

	public int getJobTestId() {
		return jobTestId;
	}

	public void setJobTestId(int jobTestId) {
		this.jobTestId = jobTestId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(String testQuestion) {
		this.testQuestion = testQuestion;
	}

	public String getTestAnswerOption1() {
		return testAnswerOption1;
	}

	public void setTestAnswerOption1(String testAnswerOption1) {
		this.testAnswerOption1 = testAnswerOption1;
	}

	public String getTestAnswerOption2() {
		return testAnswerOption2;
	}

	public void setTestAnswerOption2(String testAnswerOption2) {
		this.testAnswerOption2 = testAnswerOption2;
	}

	public String getTestAnswerOption3() {
		return testAnswerOption3;
	}

	public void setTestAnswerOption3(String testAnswerOption3) {
		this.testAnswerOption3 = testAnswerOption3;
	}

	public String getTestAnswerOption4() {
		return testAnswerOption4;
	}

	public void setTestAnswerOption4(String testAnswerOption4) {
		this.testAnswerOption4 = testAnswerOption4;
	}

	public String getTestImage() {
		return testImage;
	}

	public void setTestImage(String testImage) {
		this.testImage = testImage;
	}

}