package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDAO;
import com.student.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	/**
	 * 获取全部学生
	 * @return
	 */
	public List<Student> getAll(){
		return studentDAO.getAll();
	}
}