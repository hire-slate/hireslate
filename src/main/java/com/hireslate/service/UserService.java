package com.hireslate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.UserEntity;
import com.hireslate.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void insertUser(UserEntity user){
		userRepository.insert(user);
	}
	
	public void updateUser(UserEntity user) {
		userRepository.update(user);
	}
	
	public void deleteUser(int id) {
		userRepository.delete(id);
	}
	
	public int insertUserForCandidate(UserEntity user) {
		
		return userRepository.insertAndGetId(user);
	
	}
	
	public int doLogin(String username, String password) {
		
		int result;
		try {
		Map<String,Object> row = userRepository.getUserId(username, password);
		result = (int)row.get("User_Id");
		}
		catch(Exception e) {
		result = -1;
		}
		return result;
	}
	
	public List<UserEntity> viewUser(){
		return userRepository.view();
	}
	
	public List<UserEntity> viewUserNameEmployee(){
		return userRepository.viewUserNameEmployee();
	}
}
