package com.hireslate.model;

import java.util.Date;

public class JobStagesEntity {

	private String stageName;
	private Date stageStartDate, stageEndDate;
	private int jobId, nextStage, jobStageId;

	public JobStagesEntity(String stageName, Date stageStartDate, Date stageEndDate, int jobId, int nextStage,
			int jobStageId) {
		super();
		this.stageName = stageName;
		this.stageStartDate = stageStartDate;
		this.stageEndDate = stageEndDate;
		this.jobId = jobId;
		this.nextStage = nextStage;
		this.jobStageId = jobStageId;
	}
	
	public JobStagesEntity() {}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public Date getStageStartDate() {
		return stageStartDate;
	}

	public void setStageStartDate(Date stageStartDate) {
		this.stageStartDate = stageStartDate;
	}

	public Date getStageEndDate() {
		return stageEndDate;
	}

	public void setStageEndDate(Date stageEndDate) {
		this.stageEndDate = stageEndDate;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getNextStage() {
		return nextStage;
	}

	public void setNextStage(int nextStage) {
		this.nextStage = nextStage;
	}

	public int getJobStageId() {
		return jobStageId;
	}

	public void setJobStageId(int jobStageId) {
		this.jobStageId = jobStageId;
	}

}
