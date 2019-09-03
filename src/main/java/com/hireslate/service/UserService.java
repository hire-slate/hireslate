package com.hireslate.service;

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
}
