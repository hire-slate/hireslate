package com.hireslate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.UserEntity;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(UserEntity user) {
		String sql = "insert into user (User_Fname,User_Mname,User_Lname,User_Lname,User_Lname,User_DateOfBirth,User_AddressLine,User_AddressLandmark,User_Pincode,User_City,User_State,User_Gender,User_Role,User_UserName,User_Password) values ('"+user.getUserFname()+"','"+user.getUserMname()+"','"+user.getUserLname()+"','"+user.getUserMobileNumber()+"','"+user.getUserEmail()+"','"+user.getUserDateOfBirth()+"','"+user.getUserAddressLine()+"','"+user.getUserAddressLandmark()+"','"+user.getUserPincode()+"','"+user.getUserCity()+"','"+user.getUserState()+"','"+user.getUserGender()+"','"+user.getUserRole()+"','"+user.getUserUserName()+"','"+user.getUserPassword()+"')";                                       
		jdbcTemplate.execute(sql);
	}
	
	public void update(UserEntity user) {
		
		String sql = "update user set User_Fname='"+user.getUserFname()+"',User_Mname='"+user.getUserMname()+"',User_Lname='"+user.getUserLname()+"',User_DateOfBirth='"+user.getUserDateOfBirth()+"',User_AddressLine='"+user.getUserAddressLine()+"',User_Pincode='"+user.getUserPincode()+"',User_City='"+user.getUserCity()+"',User_State='"+user.getUserState()+"',User_Gender='"+user.getUserGender()+"',User_Role="+user.getUserRole()+"',User_UserName='"+user.getUserUserName()+"',User_Password='"+user.getUserPassword()+"' where User_Id='"+user.getUserId()+"'";
		jdbcTemplate.execute(sql);
	}
	
	public void delete(int id) {
		String sql = "delete from user where User_Id = "+id; 
		jdbcTemplate.execute(sql);
	}
}
