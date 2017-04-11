package com.student.model;

import java.io.Serializable;

/**
 * 学生
 */
public class Student extends User implements Serializable{

	private static final long serialVersionUID = -4492412758881190961L;
	/**
	 * 班级ID
	 */
	private long classesid;
	/**
	 * 班级名称
	 */
	private String classesName;
	
	public long getClassesid() {
		return classesid;
	}
	public void setClassesid(long classesid) {
		this.classesid = classesid;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
}
