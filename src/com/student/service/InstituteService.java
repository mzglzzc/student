package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.InstituteDAO;
import com.student.model.Institute;

@Service
public class InstituteService {
	@Autowired
	private InstituteDAO instituteDAO;
	
	/**
	 * 新增学院
	 * @return
	 */
	public long add(Institute ins){
		return instituteDAO.addInstitute(ins);
	}
	
	/**
	 * 获取全部学院
	 * @return
	 */
	public List<Institute> getAll(){
		return instituteDAO.getAll();
	}
	
	/**
	 * 根据ID删除学院
	 * @param ids
	 */
	public void del(long[] ids){
		instituteDAO.delInstitute(ids);
	}
	
	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	public List<Institute> getByName(String name){
		return instituteDAO.getByName(name);
	}
	
	/**
	 * 根据条件查询
	 * @param ids 学院ID
	 * @param name 学院名称
	 * @return
	 */
	public List<Institute> getByCondition(long[] ids, String name, String insno, int start, int size){
		return instituteDAO.getByCondition(ids, name, insno, start, size);
	}
	
	/**
	 * 查询指定条件的记录总数
	 * @param ids
	 * @param name
	 * @param insno
	 * @return
	 */
	public int getTotalCount(long[] ids, String name, String insno){
		return instituteDAO.getTotalCount(ids, name, insno);
	}

	/**
	 * 根据名称或编号查询
	 * @param name
	 * @param uid
	 * @return
	 */
	public List<Institute> checkNameAndUid(String name, String insno){
		return instituteDAO.checkNameAndUid(name, insno);
	}
	
}
