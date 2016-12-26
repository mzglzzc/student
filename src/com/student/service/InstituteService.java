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
	 * 获取全部学院
	 * @return
	 */
	public List<Institute> getAll(){
		return instituteDAO.getAll();
	}
}
