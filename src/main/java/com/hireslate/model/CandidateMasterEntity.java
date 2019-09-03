package com.hireslate.model;

public class CandidateMasterEntity {

	private String candidateInstitute, candidateCourseStartYear, candidateCourseEndYear, candidateLinkedIn, candidateGithub;
	private int candidateMasterId, userId, courseId, streamId;

	public CandidateMasterEntity(String candidateInstitute, String candidateCourseStartYear,
			String candidateCourseEndYear, String candidateLinkedIn, String candidateGithub, int candidateMasterId,
			int userId, int courseId, int streamId) {
		super();
		this.candidateInstitute = candidateInstitute;
		this.candidateCourseStartYear = candidateCourseStartYear;
		this.candidateCourseEndYear = candidateCourseEndYear;
		this.candidateLinkedIn = candidateLinkedIn;
		this.candidateGithub = candidateGithub;
		this.candidateMasterId = candidateMasterId;
		this.userId = userId;
		this.courseId = courseId;
		this.streamId = streamId;
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
