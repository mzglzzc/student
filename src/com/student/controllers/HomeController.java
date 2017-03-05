package com.student.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.student.model.User;
import com.student.service.StudentService;
import com.student.util.Constants;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("")
public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class.getName());
	@Autowired
	private StudentService studentService;
	
	@Get("")
	public String index(Invocation inv) {
		return "login";
	}
	
	@LoginCheckRequired
	@Get("home")
	public String home(Invocation inv) {
		return "index";
	}

	@Get("/login")
	public String login(Invocation inv, @Param("identity")short identity, @Param("name")String name,
			@Param("password")String password) {
		if(name==null || name.length()<=0 || password==null || password.length()<=0){
			return "a:/";
		}
		HttpServletRequest request = inv.getRequest();
		HttpSession session = request.getSession();
		User user = null;
		if(identity==1){
			
		} else {
			user = studentService.getByName(name);
		}
		if(user==null){
			request.setAttribute("message", "账号不存在");
			request.setAttribute("name", name);
			return "a:/";
		} else if(!user.getPassword().equals(password)){
			request.setAttribute("message", "账号或密码错误");
			request.setAttribute("name", name);
			return "a:/";
		} else {
			user.setIsTeacher(false);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(Constants.SESSION_OVER_TIME);
			return "r:home";
		}
	}
}
