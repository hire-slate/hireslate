package com.hireslate.model;

public class CandidateAttachment {
	
	private String candidateAttachmentResume,candidateAttachmentCoverLetter,candidateAttachmentPhoto;
	private int candidateAttachmentId,userId,candidateMasterId;
	
	public CandidateAttachment(String candidateAttachmentResume, String candidateAttachmentCoverLetter,
			String candidateAttachmentPhoto, int candidateAttachmentId, int userId, int candidateMasterId) {
		super();
		this.candidateAttachmentResume = candidateAttachmentResume;
		this.candidateAttachmentCoverLetter = candidateAttachmentCoverLetter;
		this.candidateAttachmentPhoto = candidateAttachmentPhoto;
		this.candidateAttachmentId = candidateAttachmentId;
		this.userId = userId;
		this.candidateMasterId = candidateMasterId;
	}

	public String getCandidateAttachmentResume() {
		return candidateAttachmentResume;
	}

	public void setCandidateAttachmentResume(String candidateAttachmentResume) {
		this.candidateAttachmentResume = candidateAttachmentResume;
	}

	public String getCandidateAttachmentCoverLetter() {
		return candidateAttachmentCoverLetter;
	}

	public void setCandidateAttachmentCoverLetter(String candidateAttachmentCoverLetter) {
		this.candidateAttachmentCoverLetter = candidateAttachmentCoverLetter;
	}

	public String getCandidateAttachmentPhoto() {
		return candidateAttachmentPhoto;
	}

	public void setCandidateAttachmentPhoto(String candidateAttachmentPhoto) {
		this.candidateAttachmentPhoto = candidateAttachmentPhoto;
	}

	public int getCandidateAttachmentId() {
		return candidateAttachmentId;
	}

	public void setCandidateAttachmentId(int candidateAttachmentId) {
		this.candidateAttachmentId = candidateAttachmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCandidateMasterId() {
		return candidateMasterId;
	}

	public void setCandidateMasterId(int candidateMasterId) {
		this.candidateMasterId = candidateMasterId;
	}
	
	

}
