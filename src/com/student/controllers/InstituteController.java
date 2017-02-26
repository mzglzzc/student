package com.student.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
	
	@Get("add")
	public String addInstitute(Invocation inv, @Param("name")String name) {
		if(StringUtils.isEmpty(name)){
			return "error";
		}
		instituteService.add(name);
		return "home";
	}
	
	@Get("getAll")
	public String getAllInstitute(){
		return "instituteList";
	}
}
