package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.model.JobMasterEntity;

public class CompanyMasterRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(CompanyMasterEntity company) {
		String sql = "insert into company_master Company_Name,Company_Website,Company_AddressLine,Company_Landmark,Company_Pincode,Company_Gsitn,Company_Pancard,Company_Contact values ('"
	+company.getCompanyName()+"','"+company.getCompanyWebsite()+"','"+company.getCompanyAddressLine()+"','"+company.getCompanyLandmark()+"',"
				+company.getCompanyPincode()+",'"+company.getCompanyGstin()+"','"+company.getCompanyPancard()+"','"+company.getCompanyContact()+"')";
		jdbcTemplate.execute(sql);
	}
	
	public void update(CompanyMasterEntity company) {
		String sql = "update company_master set Job_Name='"+company.getCompanyName()+"',Company_Website='"+company.getCompanyWebsite()+
				"',Company_AddressLine='"+company.getCompanyAddressLine()+"',Company_Landmark='"+company.getCompanyLandmark()+
				"',Company_Pincode="+company.getCompanyPincode()+",Company_Gsitn='"+company.getCompanyGstin()+"',Company_Pancard='"
				+company.getCompanyPancard()+"',Company_Contact='"+company.getCompanyContact()+"'";
		jdbcTemplate.execute(sql);
	}
	
    public void delete(int id) {
    	String sql = "delete from company_master where Company_Id="+id;
    	jdbcTemplate.execute(sql);
    }
}