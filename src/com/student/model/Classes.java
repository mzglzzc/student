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
	 * 学院ID
	 */
	private long instituteid;
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
	public long getInstituteid() {
		return instituteid;
	}
	public void setInstituteid(long instituteid) {
		this.instituteid = instituteid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
