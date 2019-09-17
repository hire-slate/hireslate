package com.hireslate.model;

public class SkillMasterEntity {

	
	private int skillId;
	private String skillName;
	
	public SkillMasterEntity() {
		
	}
	
	public SkillMasterEntity(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}
	
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}
