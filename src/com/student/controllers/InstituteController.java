package com.student.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.student.model.Institute;
import com.student.service.InstituteService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;

@Path("institute")
public class InstituteController {
	final static Logger logger = Logger.getLogger(InstituteController.class.getName());
	
	@Autowired
	private InstituteService instituteService;
	
	@Get("getList")
	public String getList(){
		return "institute/list";
	}
	
	@Get("getByCondition")
	public String getByCondition(Invocation inv, @Param("ids")long[] ids, @Param("name")String name){
		if(name!=null && name.trim().length()>0){
			name = "%" + name + "%";
		}
		List<Institute> list = instituteService.getByCondition(ids,name);
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONArray.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name) {
		if(StringUtils.isEmpty(name)){
			return "error";
		}
		instituteService.add(name);
		return "r:getList";
	}
	
	@Get("del")
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		instituteService.del(ids);
		return "r:getList";
	}
}
