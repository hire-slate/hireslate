package com.hireslate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hireslate.model.StreamMasterEntity;
import com.hireslate.repository.StreamMasterRepository;


@Service
public class StreamMasterService {

	@Autowired
	StreamMasterRepository streamMasterRepository;
	
	public List<StreamMasterEntity> viewStreamMaster(){
		return streamMasterRepository.view();
	}
	
	public void insertStreamMaster(String name,int id) {
		streamMasterRepository.insert(name, id);
	}
	
	public StreamMasterEntity viewStreamMasterById(int id) {
		return streamMasterRepository.viewById(id);
	}
	
	public void updateStreamMaster(StreamMasterEntity stream) {
		streamMasterRepository.update(stream);
	}
	
	public void deleteStreamMaster(int id) {
		streamMasterRepository.delete(id);
	}
}
