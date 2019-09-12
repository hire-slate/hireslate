package com.hireslate.model;

public class EmployeeJobMappingEntity {

	private String employeeRole;
	private int employeeJobMappingId, EmployeeId, jobId;

	public EmployeeJobMappingEntity() {
	}

	public EmployeeJobMappingEntity(String employeeRole, int employeeId, int jobId) {
		super();
		this.employeeRole = employeeRole;
		EmployeeId = employeeId;
		this.jobId = jobId;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public int getEmployeeJobMappingId() {
		return employeeJobMappingId;
	}

	public void setEmployeeJobMappingId(int employeeJobMappingId) {
		this.employeeJobMappingId = employeeJobMappingId;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

}