package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.ClassesDAO;
import com.student.model.Classes;

@Service
public class ClassesService {
	@Autowired
	private ClassesDAO classesDAO;

	/**
	 * 增
	 * @param cla
	 * @return
	 */
	public long add(String name, long majorid){
		return classesDAO.add(name, majorid);
	}
	
	/**
	 * 删
	 * @param ids
	 */
	public void del(long[] ids){
		classesDAO.del(ids);
	}
	
	/**
	 * 改
	 * @param cla
	 */
	public void update(Classes cla){
		classesDAO.update(cla);
	}
	
	/**
	 * 查
	 * @param ids
	 * @param name
	 * @return
	 */
	public List<Classes> getByCondition(long[] ids, String name){
		return classesDAO.getByCondition(ids, name);
	}
}
