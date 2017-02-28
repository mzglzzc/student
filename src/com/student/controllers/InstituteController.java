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
	
	@Get("getAdd")
	public String getAdd(){
		return "institute/add";
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name) {
		if(StringUtils.isEmpty(name)){
			return "error";
		}
		instituteService.add(name);
		return "home";
	}
	
	@Post("getAll")
	public String getAllInstitute(Invocation inv, Model model){
		List<Institute> list = instituteService.getAll();
<<<<<<< Updated upstream
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONArray.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
=======
		model.add("list", list);
		return "institute/list";
>>>>>>> Stashed changes
	}
	
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		instituteService.del(ids);
		return "";
	}
}
