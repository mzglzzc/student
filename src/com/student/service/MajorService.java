package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.MajorDAO;
import com.student.model.Major;

@Service
public class MajorService {
	@Autowired
	private MajorDAO majorDAO;
	
	/**
	 * 新增专业
	 * @return
	 */
	public long add(String name, long instituteid){
		return majorDAO.add(name, instituteid);
	}
	
	/**
	 * 删除专业
	 * @param ids
	 */
	public void del(long[] ids){
		majorDAO.del(ids);
	}
	
	/**
	 * 跟据条件查询专业
	 * @param ids 专业ID
	 * @param name 专业名称
	 * @return
	 */
	public List<Major> getByCondition(long[] ids, String name){
		return majorDAO.getByCondition(ids, name);
	}
}
