package com.student.dao;

import java.util.List;

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
	 * 新增专业
	 * @param name 专业名称
	 * @return
	 */
	@ReturnGeneratedKeys
	@SQL("insert into major(name,instituteid) values(:name,:instituteid)")
	public long add(@SQLParam("name")String name, @SQLParam("instituteid")long instituteid);
	/**
	 * 删除专业
	 * @param id 专业ID
	 */
	@SQL("delete from major where id in (:ids)")
	public void del(@SQLParam("ids") long[] ids);
	/**
	 * 根据专业ID更新专业名称
	 * @param major 专业对象
	 * @return
	 */
	@SQL("update major set name=:major.name where id=:major.id")
	public long update(@SQLParam("major") Major major);
	/**
	 * 根据指定条件查询专业
	 * @param name 专业名称
	 * @return
	 */
	@SQL("select m.id,m.name,m.ctime,m.instituteid,i.name as instituteName from major m "
			+ "join institute i on m.instituteid=i.id "
			+ "where 1=1 "
			+ "#if(:ids!=null&&:ids.size()>0){and m.id in (:ids) } "
			+ "#if(:name!=null&&:name.length()>0){and m.name like :name } "
			+ "#if(:instituteid!=null&&:instituteid!=0){and m.instituteid = :instituteid } ")
	public List<Major> getByCondition(@SQLParam("ids")long[] ids, @SQLParam("name")String name, 
			@SQLParam("instituteid")long instituteid);
	
}