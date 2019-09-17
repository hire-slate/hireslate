package com.hireslate.model;

public class JobTypeMasterEntity {

	private int jobTypeId;
	private String jobTypeName;
	
	
	public JobTypeMasterEntity() {
		
	}
	
	
	public JobTypeMasterEntity(int jobTypeId, String jobTypeName) {
		super();
		this.jobTypeId = jobTypeId;
		this.jobTypeName = jobTypeName;
	}


	public int getJobTypeId() {
		return jobTypeId;
	}


	public void setJobTypeId(int jobTypeId) {
		this.jobTypeId = jobTypeId;
	}


	public String getJobTypeName() {
		return jobTypeName;
	}


	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	
	
	
	
	
}
