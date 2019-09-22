package com.hireslate.model;

import java.util.Date;

public class JobMasterEntity {

	private int jobId;
	private String jobTitle;
	private String jobDescription;
	private String jobBenefits;
	private int jobVacancy;
	private Date jobOpeningDate;
	private Date jobClosingDate;
	private int jobTypeId;
	private int jobCompanyId;
	private float jobSalary;

	public JobMasterEntity() {
	}

	public JobMasterEntity(int jobId, String jobTitle, String jobDescription, String jobBenefits, int jobVacancy,
			Date jobOpeningDate, Date jobClosingDate, int jobTypeId,int jobCompanyId, float jobSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobBenefits = jobBenefits;
		this.jobVacancy = jobVacancy;
		this.jobOpeningDate = jobOpeningDate;
		this.jobClosingDate = jobClosingDate;
		this.jobTypeId = jobTypeId;
		this.jobCompanyId = jobCompanyId;
		this.jobSalary = jobSalary;
	}

	public int getJobCompanyId() {
		return jobCompanyId;
	}

	public void setJobCompanyId(int jobCompanyId) {
		this.jobCompanyId = jobCompanyId;
	}

	public void setJobOpeningDate(Date jobOpeningDate) {
		this.jobOpeningDate = jobOpeningDate;
	}

	public void setJobClosingDate(Date jobClosingDate) {
		this.jobClosingDate = jobClosingDate;
	}

	public int getJobId() {
		return jobId;
	}

	public Date getJobOpeningDate() {
		return jobOpeningDate;
	}

	public Date getJobClosingDate() {
		return jobClosingDate;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobBenefits() {
		return jobBenefits;
	}

	public void setJobBenefits(String jobBenefits) {
		this.jobBenefits = jobBenefits;
	}

	public int getJobVacancy() {
		return jobVacancy;
	}



	public void setJobVacancy(int jobVacancy) {
		this.jobVacancy = jobVacancy;
	}

	public int getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(int jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public float getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(float jobSalary) {
		this.jobSalary = jobSalary;
	}

}
