package com.student.model;

import java.io.Serializable;

/**
 * 教师
 */
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 3420247714414233999L;
	/**
	 * 班级ID
	 */
	private long majorid;
	/**
	 * 班级名称
	 */
	private long majorName;
	
	
	public long getMajorid() {
		return majorid;
	}
	public void setMajorid(long majorid) {
		this.majorid = majorid;
	}
	public long getMajorName() {
		return majorName;
	}
	public void setMajorName(long majorName) {
		this.majorName = majorName;
	}
}
