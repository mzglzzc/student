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
	@Get("/t1")
	public String test(Invocation inv) {
		return "test";
	}
	@Get("/t2")
	public String test2(Invocation inv) {
		return "test2";
	}
}
