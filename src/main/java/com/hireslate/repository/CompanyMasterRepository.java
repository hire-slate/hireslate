package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CompanyMasterEntity;
import com.hireslate.model.JobMasterEntity;

@Repository
public class CompanyMasterRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(CompanyMasterEntity company) {
		String sql = "insert into company_master (Company_Name, Company_Website, Company_Username,Company_Password ,Company_AddressLine, Company_Landmark, Company_City, Company_Pincode, Company_Gsitn, Company_Pancard, "
				+ "Company_Contact) values ('"+company.getCompanyName()+"','"+company.getCompanyWebsite()+"','"+company.getCompanyUsername()+"','"+company.getCompanyPassword()+"','"+company.getCompanyAddressLine()+"','"
				+company.getCompanyLandmark()+"','"+company.getCompanyCity()+"',"
				+company.getCompanyPincode()+",'"+company.getCompanyGstin()+"','"+company.getCompanyPancard()+"','"+company.getCompanyContact()+"')";
		jdbcTemplate.execute(sql);
	}

	//this method is used when we want to show company name after insertion
	public String insertAndGetId(CompanyMasterEntity company) {
		String sql = "insert into company_master (Company_Name, Company_Website, Company_Username,Company_Password ,Company_AddressLine, Company_Landmark,"
				+ " Company_City, Company_Pincode, Company_Gsitn, Company_Pancard, Company_Contact) values ('"+company.getCompanyName()+"','"
				+company.getCompanyWebsite()+"','"+company.getCompanyUsername()+"','"+company.getCompanyPassword()+"','"+company.getCompanyAddressLine()+"','"
				+company.getCompanyLandmark()+"','"+company.getCompanyCity()+"',"
				+company.getCompanyPincode()+",'"+company.getCompanyGstin()+"','"+company.getCompanyPancard()+"','"+company.getCompanyContact()+"')";
		jdbcTemplate.execute(sql);
		String sql1 = "select company_name from company_master order by company_id desc limit 1";
		Map<String,Object> row = jdbcTemplate.queryForMap(sql1);
		String companyName = (String)row.get("Company_Name");
		return companyName;
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
    
    public List<CompanyMasterEntity> viewOnlyId(){
    	String sql ="select Company_Id, Company_Name from company_master";
    	List<CompanyMasterEntity> companies = new ArrayList<CompanyMasterEntity>();
    	List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
    	for(Map<String, Object> row : rows) {
    		CompanyMasterEntity company = new CompanyMasterEntity();
    		company.setCompanyId((int)row.get("Company_Id"));
    		company.setCompanyName((String)row.get("Company_Name"));
    		companies.add(company);
    	}
    	return companies;
    }
    
   public CompanyMasterEntity getCompanyId(String username, String password) {
	   CompanyMasterEntity company = new CompanyMasterEntity();
	   System.out.println(username);
	   System.out.println(password);
	   String sql = "select Company_Id,Company_Name from company_master where Company_Website = '"+username+"' and Company_Password ='"+password+"'"; 
	   System.out.println(sql);
	   Map<String,Object> row = jdbcTemplate.queryForMap(sql);
	   System.out.println(row.get("Company_Name"));
	   if(row.size() != 0) {
	   company.setCompanyId((int)row.get("Company_Id"));
	   company.setCompanyName((String)row.get("Company_Name"));
	   }
	   return company;
   }
}