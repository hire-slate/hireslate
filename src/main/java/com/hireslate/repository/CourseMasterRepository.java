package com.hireslate.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.CourseMasterEntity;

@Repository
public class CourseMasterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<CourseMasterEntity> view(){
		
		String sql = "SELECT * FROM course_master";
		
		List<CourseMasterEntity> courses = new ArrayList<CourseMasterEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		for(Map<String,Object> row : rows) {
			CourseMasterEntity course = new CourseMasterEntity();
			course.setCourseId((int)row.get("course_id"));
			course.setCourseName((String)row.get("course_name"));
			courses.add(course);
		}
		//System.out.println(courses);
		return courses;
	}
	
	public void insert(String name) {
		String sql = "insert into course_master (course_name) values ('"+name+"')";
		jdbcTemplate.execute(sql);
	}
	
	public CourseMasterEntity viewById(int id) {
		String sql = "select * from course_master where course_id = "+ id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		CourseMasterEntity course = new CourseMasterEntity();
		
		course.setCourseId((int)row.get("course_id"));
		course.setCourseName((String)row.get("course_name"));
		return course;
	}
	
	public void update(CourseMasterEntity course) {
		String sql  = "update course_master set course_name =  '"+course.getCourseName()+"' where course_id = "+course.getCourseId();
		jdbcTemplate.execute(sql);
	}

	public void delete(int id) {
		String sql = "delete from course_master where course_id = "+id; 
		jdbcTemplate.execute(sql);
	}
}
