package com.student.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.student.model.Student;
import com.student.service.StudentService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("student")
public class StudentController {
	final static Logger logger = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	private StudentService studentService;
	
	@Get("getList")
	public String getList(){
		return "student/list";
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("stu")Student stu) {
		if(stu == null){
			return "error";
		}
		studentService.add(stu);
		return "student/list";
	}
	
	@Get("del")
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		studentService.del(ids);
		return "student/list";
	}
	
	@Get("getByCondition")
	public String getByCondition(Invocation inv, @Param("ids")long[] ids, @Param("name")String name){
		List<Student> list = studentService.getByCondition(ids,name);
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONArray.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
	}
}
