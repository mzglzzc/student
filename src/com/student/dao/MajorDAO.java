package com.student.dao;

import java.util.List;

import com.student.model.Institute;
import com.student.model.Major;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * 专业DAO
 */
@DAO
public interface MajorDAO {
	/**
	 * 新增学院
	 * @param name 学院名称
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into major(name) values(:name)")
	public long add(@SQLParam("name") String name);
	/**
	 * 删除专业
	 * @param id 学院ID
	 */
	@SQL("delete from major where id in (:ids)")
	public void del(@SQLParam("ids") long[] ids);
	/**
	 * 根据学院ID更新学院名称
	 * @param ins 学院对象
	 * @return
	 */
	@SQL("update major set name=:ins.name where id=:ins.id")
	public long update(@SQLParam("ins") Institute ins);
	/**
	 * 获取全部专业
	 * @return
	 */
	@SQL("select id, instituteid, name, ctime from major")
	public List<Major> getAll();
	/**
	 * 获取全部专业的总数
	 * @return
	 */
	@SQL("select count(id) from major")
	public int getAllCount();
	/**
	 * 根据ID查询专业
	 * @param id 学院ID
	 * @return
	 */
	@SQL("select id, instituteid， name, ctime from major where id=:id")
	public Major getByID(@SQLParam("id") long id);
	/**
	 * 根据专业名称查询学院
	 * @param name 学院名称
	 * @return
	 */
	@SQL("select id, name, ctime from institute where name like :name")
	public Major getByName(@SQLParam("name") String name);
	
}