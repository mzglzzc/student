package com.student.controllers;

import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.student.model.User;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

public class LoginInterceptor extends ControllerInterceptorAdapter {
	final static Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	public LoginInterceptor() {
	    setPriority(29600);
    }
	
    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return LoginCheckRequired.class; // 这是一个注解，只有标过的controller才会接受这个拦截器的洗礼。
    }
    
    @Override
    public Object before(Invocation inv) throws Exception {
    	HttpServletRequest request = inv.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			return "redirect:login";
		} else {
			return true;
		}
    }
}
