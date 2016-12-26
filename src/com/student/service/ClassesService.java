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
	 * 获取全部班级
	 * @return
	 */
	public List<Classes> getAll(){
		return classesDAO.getAll();
	}
	
}
