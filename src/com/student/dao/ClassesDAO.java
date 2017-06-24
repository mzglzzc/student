package com.student.dao;

import java.util.List;

import com.student.model.Classes;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * 班级DAO
 */
@DAO
public interface ClassesDAO {
	/**
	 * 新增班级
	 * @param cla 班级对象
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into classes(name,majorid) values(:name,:majorid)")
	public long add(@SQLParam("name")String name, @SQLParam("majorid")long majorid);
	/**
	 * 删除班级
	 * @param id 班级ID
	 */
	@SQL("delete from classes where id in (:ids)")
	public void del(@SQLParam("ids") long[] ids);
	/**
	 * 根据班级ID更新班级信息
	 * @param cla 班级对象
	 * @return
	 */
	@SQL("update classes set name=:cla.name,majorid=:cla.majorid "
			+ "where id=:ins.id")
	public long update(@SQLParam("cla") Classes cla);
	/**
	 * 获取全部班级
	 * @return
	 */
	@SQL("select c.id,c.name,c.majorid,m.name as majorName,c.ctime from classes c "
			+ "join major m on c.majorid=m.id "
			+ "where 1=1 "
			+ "#if(:ids!=null&&:ids.size()>0){and c.id in (:ids) } "
			+ "#if(:name!=null&&:name.length()>0){and c.name like :name } "
			+ "#if(:majorid!=null&&:majorid!=0){and c.majorid = :majorid } ")
	public List<Classes> getByCondition(@SQLParam("ids")long[] ids, @SQLParam("name")String name, 
			@SQLParam("majorid")long majorid);
}