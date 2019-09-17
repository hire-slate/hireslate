package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.UserEntity;


@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insert(UserEntity user) {
		String sql = "insert into user (User_Fname,User_Mname,User_Lname,User_DateOfBirth,User_AddressLine,User_AddressLandmark,User_Pincode,User_City,User_State,User_Gender,User_Role,User_UserName,User_Password) values ('"+user.getUserFname()+"','"+user.getUserMname()+"','"+user.getUserLname()+"','"+user.getUserMobileNumber()+"','"+user.getUserEmail()+"','"+user.getUserDateOfBirth()+"','"+user.getUserAddressLine()+"','"+user.getUserAddressLandmark()+"','"+user.getUserPincode()+"','"+user.getUserCity()+"','"+user.getUserState()+"','"+user.getUserGender()+"','"+user.getUserRole()+"','"+user.getUserUserName()+"','"+user.getUserPassword()+"')";                                       
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
	
	public int insertAndGetId(UserEntity user) {
		String sql = "insert into user (User_Fname,User_Mname,User_Lname,User_MobileNumber,User_Email,User_AddressLine,User_AddressLandmark,User_Pincode,User_City,User_State,User_Gender,User_Role,User_UserName,User_Password) values ('"+
				user.getUserFname()+"','"+user.getUserMname()+"','"+user.getUserLname()+"','"+user.getUserMobileNumber()+"','"+user.getUserEmail()+"','"+user.getUserAddressLine()+"','"+user.getUserAddressLandmark()+"',"+user.getUserPincode()
				+",'"+user.getUserCity()+"','"+user.getUserState()+"',"+user.getUserGender()+","+user.getUserRole()+",'"+user.getUserUserName()+"','"+user.getUserPassword()+"')";                                       
		jdbcTemplate.execute(sql);
		String sql1 = "select user_id from user order by user_id desc limit 1";
		Map<String,Object> row = jdbcTemplate.queryForMap(sql1);
		int userId = (int)row.get("User_Id");
		return userId;
	}
	
	
	public Map<String,Object> getUserId(String username , String password) {
		String sql = "select User_Id from user where User_UserName = '"+username+"' and User_Password = '"+password+"' ";
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		return row;
	}
	
	public List<UserEntity> view(){
		String sql = "SELECT * FROM `user`";
		List<UserEntity> users = new ArrayList<UserEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		for(Map<String,Object> row : rows) {
			UserEntity user = new UserEntity();
			user.setUserId((int)row.get("userId"));
			user.setUserFname((String)row.get("User_Fname"));
			user.setUserLname((String)row.get("User_Lname"));
			users.add(user);
		}
		return users;
	}
}
	