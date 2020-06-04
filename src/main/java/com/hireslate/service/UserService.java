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
	
	public UserEntity doLogin(String username, String password) {
	
		UserEntity user = new UserEntity();
		user = userRepository.getUser(username, password);
		if(user.getUserId() == 0) {
			user = null;
		}
		
		return user;
	}
	
	public List<UserEntity> viewUser(){
		return userRepository.view();
	}
	
	public List<UserEntity> viewUserNameEmployee(){
		return userRepository.viewUserNameEmployee();
	}
	
	public UserEntity viewUser(int userId) {
		return userRepository.getUser(userId);
	}
	
	public String getUserEmail(int userId) {
		return userRepository.getEmail(userId);
	}
}
