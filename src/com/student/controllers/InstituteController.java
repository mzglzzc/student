package com.student.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.student.model.Institute;
import com.student.service.InstituteService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

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
	public String getByCondition(Invocation inv, @Param("ids")long[] ids, @Param("name")String name, @Param("insno")String insno, 
			@Param("page")int page, @Param("rows")int rows){
		if(page==0) page = 1;
		if(rows==0) rows = 10;
		if(name!=null && name.trim().length()>0){
			name = "%" + name + "%";
		}
		List<Institute> list = instituteService.getByCondition(ids,name,insno,(page-1)*rows,rows);
		int total = instituteService.getTotalCount(ids, name, insno);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", list);
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		return "@"+JSONObject.toJSONString(jsonMap, SerializerFeature.WriteDateUseDateFormat);
	}
	
	@Get("checkValue")
	public String checkNameAndUid(Invocation inv, @Param("name")String name, @Param("insno")String insno){
		List<Institute> list = instituteService.checkNameAndUid(name,insno);
		if(list!=null && list.size()>0){
			return "@var isUnique = false;";
		} else {
			return "@var isUnique = true;";
		}
	}
	
	@Get("checkName")
	public String checkName(Invocation inv, @Param("name")String name){
		List<Institute> list = instituteService.getByName(name);
		if(list!=null && list.size()>0){
			return "@var isNameUnique = false;";
		} else {
			return "@var isNameUnique = true;";
		}
	}
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name, @Param("insno")String insno) {
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(insno)){
			return "error";
		}
		Institute ins = new Institute();
		ins.setName(name);
		ins.setInsno(insno);
		instituteService.add(ins);
		return "institute/list";
	}
	
	@Get("del")
	public String delInstitute(Invocation inv, @Param("ids")long[] ids){
		instituteService.del(ids);
		return "institute/list";
	}
}
