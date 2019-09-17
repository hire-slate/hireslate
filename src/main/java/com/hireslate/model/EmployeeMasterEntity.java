package com.hireslate.model;

public class EmployeeMasterEntity {

	private int employeeId, companyId, userId;

	public EmployeeMasterEntity(int employeeId, int companyId, int userId) {
		super();
		this.employeeId = employeeId;
		this.companyId = companyId;
		this.userId = userId;
	}

	public EmployeeMasterEntity() {
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
