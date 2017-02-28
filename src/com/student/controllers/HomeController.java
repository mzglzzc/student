package com.student.controllers;

import org.apache.log4j.Logger;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("")
public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class.getName());
	
	@Get("")
	public String index(Invocation inv) {
		return "index";
	}
	@Get("/stuList")
	public String test(Invocation inv) {
		return "stuList";
	}
	@Get("/stuAdd")
	public String test2(Invocation inv) {
		return "stuAdd";
	}
}
