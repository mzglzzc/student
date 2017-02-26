package com.student.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级
 */
public class Major implements Serializable {
	
	private static final long serialVersionUID = 3829460016585613099L;
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 学院ID
	 */
	private long instituteid;
	/**
	 * 班级名称
	 */
	private String name;
	/**
	 * 序号
	 */
	private int seq;
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
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
