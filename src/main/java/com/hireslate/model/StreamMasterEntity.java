package com.hireslate.model;

public class StreamMasterEntity {

	private int streamId;
	private String streamName;
	private int courseId;

	public StreamMasterEntity() {
		super();
	}

	public StreamMasterEntity(int streamId, String streamName, int courseId) {
		super();
		this.streamId = streamId;
		this.streamName = streamName;
		this.courseId = courseId;
	}

	public String getCourseName() {
		return "";
	}
	public int getStreamId() {
		return streamId;
	}

	public void setStreamId(int streamId) {
		this.streamId = streamId;
	}

	public String getStreamName() {
		return streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
}
	
