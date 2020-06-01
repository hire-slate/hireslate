package com.hireslate.model;

public class CandidateMasterEntity {

	private String candidateInstitute, candidateCourseStartYear, candidateCourseEndYear, candidateLinkedIn, candidateGithub,candidateUniversity;
	private int candidateMasterId, userId, courseId, streamId;


	public CandidateMasterEntity(String candidateInstitute, String candidateCourseStartYear,
			String candidateCourseEndYear, String candidateLinkedIn, String candidateGithub, String candidateUniversity,
			int candidateMasterId, int userId, int courseId, int streamId) {
		super();
		this.candidateInstitute = candidateInstitute;
		this.candidateCourseStartYear = candidateCourseStartYear;
		this.candidateCourseEndYear = candidateCourseEndYear;
		this.candidateLinkedIn = candidateLinkedIn;
		this.candidateGithub = candidateGithub;
		this.candidateUniversity = candidateUniversity;
		this.candidateMasterId = candidateMasterId;
		this.userId = userId;
		this.courseId = courseId;
		this.streamId = streamId;
	}



	public CandidateMasterEntity() {
		super();
	}

	public String getCandidateUniversity() {
		return candidateUniversity;
	}



	public void setCandidateUniversity(String candidateUniversity) {
		this.candidateUniversity = candidateUniversity;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStreamId() {
		return streamId;
	}

	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}

	public String getCandidateInstitute() {
		return candidateInstitute;
	}

	public void setCandidateInstitute(String candidateInstitute) {
		this.candidateInstitute = candidateInstitute;
	}

	public String getCandidateCourseStartYear() {
		return candidateCourseStartYear;
	}

	public void setCandidateCourseStartYear(String candidateCourseStartYear) {
		this.candidateCourseStartYear = candidateCourseStartYear;
	}

	public String getCandidateCourseEndYear() {
		return candidateCourseEndYear;
	}

	public void setCandidateCourseEndYear(String candidateCourseEndYear) {
		this.candidateCourseEndYear = candidateCourseEndYear;
	}

	public String getCandidateLinkedIn() {
		return candidateLinkedIn;
	}

	public void setCandidateLinkedIn(String candidateLinkedIn) {
		this.candidateLinkedIn = candidateLinkedIn;
	}

	public String getCandidateGithub() {
		return candidateGithub;
	}

	public void setCandidateGithub(String candidateGithub) {
		this.candidateGithub = candidateGithub;
	}

	public int getCandidateMasterId() {
		return candidateMasterId;
	}

	public void setCandidateMasterId(int candidateMasterId) {
		this.candidateMasterId = candidateMasterId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
