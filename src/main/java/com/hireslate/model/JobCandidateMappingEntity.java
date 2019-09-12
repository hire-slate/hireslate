package com.hireslate.model;

public class JobCandidateMappingEntity {

	private int jobCandidateId, JobId, userId, jobCurrentStage;
	private float jobCurrentSalary, jobExpectedSalary;
	private String jobChangeReason;

	public JobCandidateMappingEntity() {
	}

	public JobCandidateMappingEntity(int jobId, int userId, int jobCurrentStage, float jobCurrentSalary,
			float jobExpectedSalary, String jobChangeReason) {
		super();
		JobId = jobId;
		this.userId = userId;
		this.jobCurrentStage = jobCurrentStage;
		this.jobCurrentSalary = jobCurrentSalary;
		this.jobExpectedSalary = jobExpectedSalary;
		this.jobChangeReason = jobChangeReason;
	}

	public int getJobCandidateId() {
		return jobCandidateId;
	}

	public void setJobCandidateId(int jobCandidateId) {
		this.jobCandidateId = jobCandidateId;
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJobCurrentStage() {
		return jobCurrentStage;
	}

	public void setJobCurrentStage(int jobCurrentStage) {
		this.jobCurrentStage = jobCurrentStage;
	}

	public float getJobCurrentSalary() {
		return jobCurrentSalary;
	}

	public void setJobCurrentSalary(float jobCurrentSalary) {
		this.jobCurrentSalary = jobCurrentSalary;
	}

	public float getJobExpectedSalary() {
		return jobExpectedSalary;
	}

	public void setJobExpectedSalary(float jobExpectedSalary) {
		this.jobExpectedSalary = jobExpectedSalary;
	}

	public String getJobChangeReason() {
		return jobChangeReason;
	}

	public void setJobChangeReason(String jobChangeReason) {
		this.jobChangeReason = jobChangeReason;
	}

}
