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
	@SQL("insert into classes(name,instituteid) values(:cla.name,:cla.instituteid)")
	public long addClasses(@SQLParam("cla") Classes cla);
	/**
	 * 删除班级
	 * @param id 班级ID
	 */
	@SQL("delete from classes where id=:id")
	public void delClasses(@SQLParam("id") long id);
	/**
	 * 根据班级ID更新班级信息
	 * @param cla 班级对象
	 * @return
	 */
	@SQL("update classes set name=:cla.name,instituteid=:cla.instituteid "
			+ "where id=:ins.id")
	public long updClasses(@SQLParam("cla") Classes cla);
	/**
	 * 获取全部班级
	 * @return
	 */
	@SQL("select id,name,instituteid,ctime from classes order by id desc")
	public List<Classes> getAll();
	/**
	 * 获取全部班级的总数
	 * @return
	 */
	@SQL("select count(id) from classes")
	public int getAllCount();
}