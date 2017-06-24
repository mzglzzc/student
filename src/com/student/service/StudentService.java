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
	 * 增
	 * @param cla
	 * @return
	 */
	public long add(Student student){
		return studentDAO.add(student);
	}
	
	/**
	 * 删
	 * @param ids
	 */
	public void del(long[] ids){
		studentDAO.del(ids);
	}
	
	/**
	 * 改
	 * @param cla
	 */
	public void update(Student student){
		studentDAO.update(student);
	}
	
	/**
	 * 查
	 * @param name
	 * @return
	 */
	public Student getByName(String name){
		return studentDAO.getByName(name);
	}
	
	/**
	 * 查
	 * @param ids
	 * @param name
	 * @return
	 */
	public List<Student> getByCondition(long[] ids, String name, int start, int size){
		return studentDAO.getByCondition(ids, name, start, size);
	}
	public int getTotalCount(long[] ids, String name){
		return studentDAO.getTotalCount(ids, name);
	}
}