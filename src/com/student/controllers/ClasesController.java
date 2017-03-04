package com.student.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.student.model.Classes;
import com.student.service.ClassesService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("classes")
public class ClasesController {
	final static Logger logger = Logger.getLogger(ClasesController.class.getName());
	
	@Autowired
	private ClassesService classesService;
	
	@Get("getList")
	public String getList(){
		return "major/list";
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name, @Param("majorid")long majorid) {
		if(StringUtils.isEmpty(name)){
			return "error";
		}
		classesService.add(name, majorid);
		return "classes/list";
	}
	
	@Get("del")
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		classesService.del(ids);
		return "classes/list";
	}
	
	@Get("getByCondition")
	public String getByCondition(Invocation inv, @Param("ids")long[] ids, @Param("name")String name){
		List<Classes> list = classesService.getByCondition(ids,name);
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONArray.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
	}
}
