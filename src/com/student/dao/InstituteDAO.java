package com.student.dao;

import java.util.List;

import com.student.model.Institute;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * 学院DAO
 */
@DAO
public interface InstituteDAO {
	/**
	 * 新增学院
	 * @param name 学院名称
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into institute(name) values(:name)")
	public long addInstitute(@SQLParam("name") String name);
	/**
	 * 删除学院
	 * @param id 学院ID
	 */
	@SQL("delete from institute where id in (:ids)")
	public void delInstitute(@SQLParam("ids") long[] ids);
	/**
	 * 根据学院ID更新学院名称
	 * @param ins 学院对象
	 * @return
	 */
	@SQL("update institute set name=:ins.name where id=:ins.id")
	public long updInstitute(@SQLParam("ins") Institute ins);
	/**
	 * 获取全部学院
	 * @return
	 */
	@SQL("select id, name, ctime from institute")
	public List<Institute> getAll();
	/**
	 * 获取全部学院的总数
	 * @return
	 */
	@SQL("select count(id) from institute")
	public int getAllCount();
	/**
	 * 根据ID查询学院
	 * @param id 学院ID
	 * @return
	 */
	@SQL("select id, name, ctime from institute where id=:id")
	public Institute getByID(@SQLParam("id") long id);
	/**
	 * 根据学院名称查询学院
	 * @param name 学院名称
	 * @return
	 */
	@SQL("select id, name, ctime from institute where name=:name")
	public Institute getByName(@SQLParam("name") String name);
	/**
	 * 根据指定条件查询学院
	 * @param name 学院名称
	 * @return
	 */
	@SQL("select id,name,ctime from institute where 1=1 "
			+ "#if(:ids!=null&&:ids.size()>0){and id in (:ids) } "
			+ "#if(:name!=null&&:name.length()>0){and name like :name } ")
	public List<Institute> getByCondition(@SQLParam("ids")long[] ids, @SQLParam("name")String name);
	
}