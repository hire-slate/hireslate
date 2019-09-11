package com.hireslate.model;

public class CandidateResultEntity {
	private String remarks;
	private int candidateResultId, candidateMasterId, jobId, jobTestId, totalMarks, employeeId, obtainedMarks;

	public CandidateResultEntity() {
	}

	public CandidateResultEntity(String remarks, int candidateMasterId, int jobId, int jobTestId, int totalMarks,
			int employeeId) {
		super();
		this.remarks = remarks;
		this.candidateMasterId = candidateMasterId;
		this.jobId = jobId;
		this.jobTestId = jobTestId;
		this.totalMarks = totalMarks;
		this.employeeId = employeeId;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCandidateResultId() {
		return candidateResultId;
	}

	public void setCandidateResultId(int candidateResultId) {
		this.candidateResultId = candidateResultId;
	}

	public int getCandidateMasterId() {
		return candidateMasterId;
	}

	public void setCandidateMasterId(int candidateMasterId) {
		this.candidateMasterId = candidateMasterId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobTestId() {
		return jobTestId;
	}

	public void setJobTestId(int jobTestId) {
		this.jobTestId = jobTestId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
