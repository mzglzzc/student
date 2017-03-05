package com.student.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级
 */
public class Classes implements Serializable {

	private static final long serialVersionUID = 3428461634315833792L;

	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 班级名称
	 */
	private String name;
	/**
	 * 专业ID
	 */
	private long majorid;
	/**
	 * 专业名称
	 */
	private String majorName;
	/**
	 * 创建时间
	 */
	private Date ctime;
	
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
	public long getMajorid() {
		return majorid;
	}
	public void setMajorid(long majorid) {
		this.majorid = majorid;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
