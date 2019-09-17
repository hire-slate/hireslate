package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CourseMasterEntity;
import com.hireslate.model.StreamMasterEntity;

@Repository
public class StreamMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<StreamMasterEntity> view(){
		
		String sql = "SELECT stream_master.*,course_master.Course_Name FROM stream_master,course_master "
				+ "WHERE stream_master.Course_Id = course_master.Course_Id";
		List<StreamMasterEntity> streams = new ArrayList<StreamMasterEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			
			StreamMasterEntity stream = new StreamMasterEntity();
			stream.setStreamId((int)row.get("stream_id"));
			stream.setStreamName((String)row.get("stream_name"));
			stream.setCourseId((int)row.get("course_id"));	
			streams.add(stream);
			
		}
	
		return streams;
	}
	
	public void insert(String name,int id) {
		String sql = "insert into stream_master (stream_name,course_id) values ('"+name+"',"+id+")";
		jdbcTemplate.execute(sql);
		
	}
	
	public void update(StreamMasterEntity stream) {
		String sql = "update stream_master set stream_name = '"+stream.getStreamName()+"',course_id = "+stream.getCourseId()+" where stream_id = "+stream.getStreamId()+";"; 
		jdbcTemplate.execute(sql);
	}
	
	public StreamMasterEntity viewById(int id) {
		String sql = "select * from stream_master where stream_id = "+ id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		StreamMasterEntity stream = new StreamMasterEntity();
		stream.setStreamId((int)row.get("stream_id"));
		stream.setStreamName((String)row.get("stream_name"));
		stream.setCourseId((int)row.get("course_id"));
		return stream;
	}
	
	public void delete(int id) {
		String sql = "delete from stream_master where stream_id = "+id; 
		jdbcTemplate.execute(sql);
	}

}
