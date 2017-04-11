package com.student.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class User {
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 学号/工号
	 */
	private long uid;
	/**
	 * 密码
	 */
	private String password;
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
	 * 身份证号
	 */
	private String idcard;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 入学时间/入职时间
	 */
	private Date entry_time;
	/**
	 * 创建时间
	 */
	private Date ctime;
	/**
	 * 是否是教师：0否；1是
	 */
	private boolean isTeacher;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		if(this.isTeacher){
			map.put("工号", this.uid);
			map.put("入职时间", this.entry_time);
		} else {
			map.put("学号", this.uid);
			map.put("入学时间", this.entry_time);
		}
		map.put("姓名", this.name);
		map.put("性别", this.sex==0?"女":"男");
		map.put("生日", this.birthday);
		map.put("身份证", this.idcard);
		map.put("手机", this.tel);
		map.put("地址", this.address);
		return map;
	}
}
