package com.student.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学院
 */
public class Institute implements Serializable {
	private static final long serialVersionUID = -7048676587657229379L;
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 学院编号
	 */
	private String insno;
	/**
	 * 学院名称
	 */
	private String name;
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
	public String getInsno() {
		return insno;
	}
	public void setInsno(String insno) {
		this.insno = insno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
}
