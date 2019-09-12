package com.hireslate.model;

public class CandidateSkillMappingEntity {

	private int candidateSkillId, userId, skillId, endorsedSkill;

	public CandidateSkillMappingEntity() {
	}

	public CandidateSkillMappingEntity(int userId, int skillId, int endorsedSkill) {
		super();
		this.candidateSkillId = candidateSkillId;
		this.userId = userId;
		this.skillId = skillId;
		this.endorsedSkill = endorsedSkill;
	}

	public int getCandidateSkillId() {
		return candidateSkillId;
	}

	public void setCandidateSkillId(int candidateSkillId) {
		this.candidateSkillId = candidateSkillId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getEndorsedSkill() {
		return endorsedSkill;
	}

	public void setEndorsedSkill(int endorsedSkill) {
		this.endorsedSkill = endorsedSkill;
	}

}
