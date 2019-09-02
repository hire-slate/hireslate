package com.hireslate.model;

public class CourseMasterEntity {

	private int courseId;
	private String courseName;

	public CourseMasterEntity() {
		
	}
	
	public CourseMasterEntity(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
