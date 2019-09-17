package com.hireslate.model;

import java.util.Date;

public class JobTestEntity {

	private int jobTestId, companyId, jobStageId, totalMarks;
	private Date duration;

	public JobTestEntity() {
	}

	public JobTestEntity(int companyId, int jobStageId, int totalMarks, Date duration) {
		super();
		this.jobTestId = jobTestId;
		this.companyId = companyId;
		this.jobStageId = jobStageId;
		this.totalMarks = totalMarks;
		this.duration = duration;
	}

	public int getJobTestId() {
		return jobTestId;
	}

	public void setJobTestId(int jobTestId) {
		this.jobTestId = jobTestId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getJobStageId() {
		return jobStageId;
	}

	public void setJobStageId(int jobStageId) {
		this.jobStageId = jobStageId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

}
