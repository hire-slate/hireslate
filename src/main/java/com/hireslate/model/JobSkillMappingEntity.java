package com.hireslate.model;

public class JobSkillMappingEntity {

	private int jobSkillMappingId, jobId, skillId, jobSkillPriority;

	public JobSkillMappingEntity() {
	}

	public JobSkillMappingEntity(int jobId, int skillId, int jobSkillPriority) {
		super();
		this.jobId = jobId;
		this.skillId = skillId;
		this.jobSkillPriority = jobSkillPriority;
	}

	public int getJobSkillMappingId() {
		return jobSkillMappingId;
	}

	public void setJobSkillMappingId(int jobSkillMappingId) {
		this.jobSkillMappingId = jobSkillMappingId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getJobSkillPriority() {
		return jobSkillPriority;
	}

	public void setJobSkillPriority(int jobSkillPriority) {
		this.jobSkillPriority = jobSkillPriority;
	}

}
