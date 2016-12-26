package com.student.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -4492412758881190961L;
	
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别：0-女；1-男
	 */
	private short sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 入学时间
	 */
	private Date entry_time;
	/**
	 * 班级ID
	 */
	private long classesid;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 修改时间
	 */
	private Date utime;
	
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
	public short getSex() {
		return sex;
	}
	public void setSex(short sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public long getClassesid() {
		return classesid;
	}
	public void setClassesid(long classesid) {
		this.classesid = classesid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getUtime() {
		return utime;
	}
	public void setUtime(Date utime) {
		this.utime = utime;
	}
}
