package com.student.model;

public abstract class User {
	private long id;
	private String name;
	private String password;
	private boolean isTeacher;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setIsTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	
}
