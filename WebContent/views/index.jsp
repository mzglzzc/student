<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生管理系统</title>
    <%@include file="/views/include/common.jsp"%>
<link rel="stylesheet" href="/student/static/font-awesome/css/font-awesome.min.css">
    <style>
	   .hback{background-color:#6599DC}
	   #cloud1{color:#fff;font-size:6em;position:fixed;right:100px;top:20px}
	   #cloud2{color:#fff;font-size:5em;position:fixed;right:200px;top:50px}
	   #th1{color:#fff;margin:40px 30px;}
    </style>
</head>
<body class="easyui-layout">
    <div region="north" style="height:160px;" class="hback">
		<a href="logout" style="float:right;font-size:20px;">退出</a>
    	<i class="icon-cloud" id="cloud1"></i>
    	<i class="icon-cloud" id="cloud2"></i>
		<h1 id="th1">学生管理系统</h1>
	</div>
	<div data-options="region:'west',title:'导航'" style="width:180px;">
		<div class="easyui-accordion leftNav" data-options="multiple:true" >
	        <div title="基础信息">
	            <ul>
	            	<li><a onclick="addTab('add1','institute/getList')">个人信息</a></li>
	            </ul>
	        </div>
	        <div title="信息统计">
	            <ul>
	            	<li><a onclick="addTab('add1','institute/getList')">学生统计</a></li>
	            </ul>
	        </div>
	        <div title="系统管理">
	            <ul>
	            	<li><a onclick="addTab('学院管理','institute/getList')">学院管理</a></li>
	            	<li><a onclick="addTab('专业管理','major/getList')">专业管理</a></li>
	            	<li><a onclick="addTab('班级管理','classes/getList')">班级管理</a></li>
	            	<li><a onclick="addTab('学生管理','student/getList')">学生管理</a></li>
	            	<li><a onclick="addTab('日志管理','log/getList')">日志管理</a></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<div id="content" region="center">
		<div class="easyui-tabs" plain="true" id="tab1">
	       
	    </div>
	</div>
	<%@include file="/views/include/comjs.jsp"%>
    <script>
    	function addTab(title, url){
    		if ($('#tab1').tabs('exists', title)){
    			$('#tab1').tabs('select', title);
    		} else {
    			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" class="tabWrap"></iframe>';
    			$('#tab1').tabs('add',{
    				title:title,
    				content:content,
    				closable:true
    			});
    		}
    	}
    </script>
</body>
</html>