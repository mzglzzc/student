package com.student.dao;

import java.util.List;

import com.student.model.Student;
import com.student.util.Constants;

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
	 * 增
	 * @param stu 学生对象
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into student(uid,password,name,sex,birthday,entry_time,classesid) "
			+ "values(:stu.uid,ENCODE(:stu.password,'"+Constants.MYSQL_KEY+"'),:stu.name,"
					+ ":stu.sex,:stu.birthday,:stu.entry_time,:stu.classesid)")
	public long add(@SQLParam("stu") Student stu);
	/**
	 * 删
	 * @param id 学生ID
	 */
	@SQL("delete from student where id in (:ids)")
	public void del(@SQLParam("ids")long[] ids);
	/**
	 * 改
	 * @param stu 学生对象
	 * @return
	 */
	@SQL("update student set name=:stu.name,sex=:stu.sex,birthday=:stu.birthday,"
			+ "entry_time=:stu.entry_time,classesid=:stu.classesid "
			+ "where id=:ins.id")
	public long update(@SQLParam("stu") Student stu);
	/**
	 * 查
	 * @return
	 */
	@SQL("select s.id,s.uid,DECODE(s.password,'"+Constants.MYSQL_KEY+"') as password,s.name,s.classesid,c.name as classesName,s.ctime "
			+ "from student s "
			+ "join classes c on s.classesid=c.id "
			+ "where s.name = :name")
	public Student getByName(@SQLParam("name")String name);
	@SQL("select s.id,s.uid,DECODE(s.password,'"+Constants.MYSQL_KEY+"') as password,s.name,s.classesid,c.name as classesName,s.ctime "
			+ "from student s "
			+ "join classes c on s.classesid=c.id "
			+ "where 1=1 "
			+ "#if(:ids!=null&&:ids.size()>0){and s.id in (:ids) } "
			+ "#if(:name!=null&&:name.length()>0){and s.name like :name } "
			+ "limit :start,:size")
	public List<Student> getByCondition(@SQLParam("ids")long[] ids, @SQLParam("name")String name, @SQLParam("start")int start, @SQLParam("size")int size);
	@SQL("select count(s.id) "
			+ "from student s "
			+ "join classes c on s.classesid=c.id "
			+ "where 1=1 "
			+ "#if(:ids!=null&&:ids.size()>0){and s.id in (:ids) } "
			+ "#if(:name!=null&&:name.length()>0){and s.name like :name } ")
	public int getTotalCount(@SQLParam("ids")long[] ids, @SQLParam("name")String name);
	
}