package com.student.dao;

import java.util.List;

import com.student.model.Student;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * 学生DAO
 */
@DAO
public interface StudentDAO {
	/**
	 * 新增学生
	 * @param stu 学生对象
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into student(name,sex,birthday,entry_time,classesid) "
			+ "values(:stu.name,:stu.sex,:stu.birthday,:stu.entry_time,:stu.classesid)")
	public long addStudent(@SQLParam("stu") Student stu);
	/**
	 * 删除学生
	 * @param id 学生ID
	 */
	@SQL("delete from student where id=:id")
	public void delStudent(@SQLParam("id") long id);
	/**
	 * 根据学生ID更新学生信息
	 * @param stu 学生对象
	 * @return
	 */
	@SQL("update student set name=:stu.name,sex=:stu.sex,birthday=:stu.birthday,"
			+ "entry_time=:stu.entry_time,classesid=:stu.classesid "
			+ "where id=:ins.id")
	public long updStudent(@SQLParam("stu") Student stu);
	/**
	 * 获取全部学生
	 * @return
	 */
	@SQL("select id,name,sex,birthday,entry_time,classesid,ctime,utime from student order by id desc")
	public List<Student> getAll();
	/**
	 * 获取全部学生的总数
	 * @return
	 */
	@SQL("select count(id) from student")
	public int getAllCount();
}