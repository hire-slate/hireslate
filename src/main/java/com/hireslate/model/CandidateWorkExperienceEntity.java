package com.hireslate.model;

import java.util.Date;

public class CandidateWorkExperienceEntity {

	private String candidateWorkTitle, candidateCompanyName;
	private int userId, candidateCurrentJob, candidateMasterId, candidateWorkExperienceId;
	private Date  candidateCompanyStartYear, candidateCompanyEndYear;

	public CandidateWorkExperienceEntity() {}
	public CandidateWorkExperienceEntity(String candidateWorkTitle, String candidateCompanyName,
			Date candidateCompanyStartYear, Date candidateCompanyEndYear, int candidateMasterId, int userId,
			int candidateCurrentJob) {
		super();
		this.candidateWorkTitle = candidateWorkTitle;
		this.candidateCompanyName = candidateCompanyName;
		this.candidateCompanyStartYear = candidateCompanyStartYear;
		this.candidateCompanyEndYear = candidateCompanyEndYear;
		this.candidateMasterId = candidateMasterId;
		this.userId = userId;
		this.candidateCurrentJob = candidateCurrentJob;
	}
	
	

	public int getCandidateWorkExperienceId() {
		return candidateWorkExperienceId;
	}
	public void setCandidateWorkExperienceId(int candidateWorkExperienceId) {
		this.candidateWorkExperienceId = candidateWorkExperienceId;
	}
	public String getCandidateWorkTitle() {
		return candidateWorkTitle;
	}

	public void setCandidateWorkTitle(String candidateWorkTitle) {
		this.candidateWorkTitle = candidateWorkTitle;
	}

	public String getCandidateCompanyName() {
		return candidateCompanyName;
	}

	public void setCandidateCompanyName(String candidateCompanyName) {
		candidateCompanyName = candidateCompanyName;
	}

	public Date getCandidateCompanyStartYear() {
		return candidateCompanyStartYear;
	}

	public void setCandidateCompanyStartYear(Date candidateCompanyStartYear) {
		this.candidateCompanyStartYear = candidateCompanyStartYear;
	}

	public Date getCandidateCompanyEndYear() {
		return candidateCompanyEndYear;
	}

	public void setCandidateCompanyEndYear(Date candidateCompanyEndYear) {
		this.candidateCompanyEndYear = candidateCompanyEndYear;
	}

	public int getCandidateMasterId() {
		return candidateMasterId;
	}

	public void setCandidateMasterId(int candidateMasterId) {
		this.candidateMasterId = candidateMasterId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		userId = userId;
	}

	public int getCandidateCurrentJob() {
		return candidateCurrentJob;
	}

	public void setCandidateCurrentJob(int candidateCurrentJob) {
		this.candidateCurrentJob = candidateCurrentJob;
	}

}
