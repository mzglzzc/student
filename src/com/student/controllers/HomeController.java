package com.student.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import net.paoding.rose.web.annotation.rest.Post;

@Path("")
public class HomeController {
	final static Logger logger = Logger.getLogger(HomeController.class.getName());
	@Autowired
	private StudentService studentService;
	
	@Get("")
	public String indexGet(Invocation inv) {
		return "r:home";
	}
	
	@LoginCheckRequired
	@Get("home")
	public String home(Invocation inv) {
		return "index";
	}

	@Post("login")
	public String login(Invocation inv, @Param("identity")short identity, @Param("name")String name,
			@Param("password")String password) {
		if(name==null || name.length()<=0 || password==null || password.length()<=0){
			return "login";
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
			return "login";
		} else if(!user.getPassword().equals(password)){
			request.setAttribute("message", "账号或密码错误");
			request.setAttribute("name", name);
			return "login";
		} else {
			ServletContext application = inv.getServletContext();
			@SuppressWarnings("unchecked")
			List<HttpSession> sessions = (List<HttpSession>)application.getAttribute("sessionlist");
			if(sessions==null || sessions.size()<=0){
				sessions = new ArrayList<HttpSession>();
			}
			for(int i=0; i<sessions.size(); i++){
				HttpSession ses = sessions.get(i);
				User usr = (User)ses.getAttribute("user");
				if(usr!=null && usr.getName().equals(user.getName())){
					ses.removeAttribute("user");
					sessions.remove(ses);
					break;
				}
			}
			user.setIsTeacher(false);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(Constants.SESSION_OVER_TIME);
			sessions.add(session);
			application.setAttribute("sessionlist", sessions);
			return "r:home";
		}
	}
	
	@Get("logout")
	public String logout(Invocation inv){
		HttpServletRequest request = inv.getRequest();
		request.getSession().removeAttribute("user");
		request.setAttribute("message", "已退出");
		return "login";
	}
}
