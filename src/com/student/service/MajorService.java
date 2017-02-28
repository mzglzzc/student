package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.InstituteDAO;
import com.student.dao.MajorDAO;
import com.student.model.Institute;
import com.student.model.Major;

@Service
public class MajorService {
	@Autowired
	private MajorDAO majorDAO;
	
	/**
	 * 新增专业
	 * @return
	 */
	public long add(String name){
		return majorDAO.add(name);
	}
	
	/**
	 * 获取全部专业
	 * @return
	 */
	public List<Major> getAll(){
		return majorDAO.getAll();
	}
	
	/**
	 * 删除专业
	 * @param ids
	 */
	public void del(long[] ids){
		majorDAO.del(ids);
	}
	
	
	public List<Major> getByCondition(long[] ids, String name){
		return majorDAO.getByCondition(ids, name);
	}
}
