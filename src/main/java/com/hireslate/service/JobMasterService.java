package com.hireslate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.JobMasterEntity;
import com.hireslate.repository.JobMasterRepository;

@Service
public class JobMasterService {

	@Autowired
	JobMasterRepository jobMasterRepository;
	
	public List<JobMasterEntity> viewJobMaster(int companyId){
		return jobMasterRepository.view(companyId);
	}
	
	public void insertJobMaster(JobMasterEntity job) {
		jobMasterRepository.insert(job);
	}
	
	public int insertJobMasterAndGetID(JobMasterEntity job) {
		return jobMasterRepository.insertAndGetId(job);
	}
	public void updateJobMaster(JobMasterEntity job) {
		jobMasterRepository.update(job);
	}
	
	public void deleteJobMaster(int id) {
		jobMasterRepository.delete(id);
	}
	
	public JobMasterEntity viewJobMasterById(int id) {
		return jobMasterRepository.viewById(id);
	}
	
	public List<String> searchJobBySkill(String skill){
		return jobMasterRepository.jobSearch(skill);
	}
	
	public Map<String, Object> viewJobDescription(int jobId){
		return jobMasterRepository.viewDescription(jobId);
	}
//	public List<List> searchJobByCompany(String companyId){
//		return jobMasterRepository.jobSearchByCompany(companyId);
//	}
	
	public List<Map<String,Object>> searchJobByCompany(String companyId){
		return jobMasterRepository.jobSearchByCompany(companyId);
	}
	public long totalJobs() {
		long totalJobs = jobMasterRepository.totalJobs();
		totalJobs=totalJobs/5;
		return totalJobs*5;
	}
	
	public String getJobTitle(int jobId) {
		return jobMasterRepository.getJobTitle(jobId);
	}
}
	