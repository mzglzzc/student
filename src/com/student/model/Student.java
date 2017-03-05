package com.student.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 */
public class Student extends User implements Serializable{

	private static final long serialVersionUID = -4492412758881190961L;
	
	/**
	 * 主键ID
	 */
	private long id;
	/**
	 * 学号
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
	 * 入学时间
	 */
	private Date entry_time;
	/**
	 * 班级ID
	 */
	private long classesid;
	/**
	 * 班级名称
	 */
	private String classesName;
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
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", uid=" + uid + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", idcard=" + idcard + ", tel=" + tel + ", address=" + address
				+ ", entry_time=" + entry_time + ", classesid=" + classesid + ", classesName=" + classesName
				+ ", ctime=" + ctime + "]";
	}
}
