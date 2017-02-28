package com.student.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.student.model.Institute;
import com.student.model.Major;
import com.student.service.InstituteService;
import com.student.service.MajorService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;

@Path("major")
public class MajorController {
	final static Logger logger = Logger.getLogger(MajorController.class.getName());
	
	@Autowired
	private MajorService majorService;
	
	@Get("getAdd")
	public String getAdd(){
		return "institute/add";
	}
	
	@Get("getList")
	public String getList(){
		return "majorList";
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name) {
		if(StringUtils.isEmpty(name)){
			return "error";
		}
		majorService.add(name);
		return "home";
	}
	
	@Post("getAll")
	public String getAllInstitute(Invocation inv, Model model){
		List<Major> list = majorService.getAll();
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONArray.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
	}
	
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		majorService.del(ids);
		return "";
	}
	
	@Get("getByCondition")
	public String getByCondition(Invocation inv, @Param("ids")long[] ids, @Param("name")String name){
		majorService.getByCondition(ids,name);
		return "";
	}
}
