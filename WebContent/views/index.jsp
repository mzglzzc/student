<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生管理系统</title>
    <link rel="stylesheet" type="text/css" href="/student/static/jquery-easyui-1.5.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/student/static/jquery-easyui-1.5.1/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/student/static/css/main.css">
    <%@include file="/views/include/common.jsp"%>
</head>
<body class="easyui-layout">
    <div region="north" style="height:160px;">
		<h1>学生管理系统</h1>
	</div>
	<div data-options="region:'west',title:'Navigator'" style="width:180px;">
		<div class="easyui-accordion" data-options="multiple:true" >
	        <div title="基础信息">
	            <ul>
	            	<li><a onclick="addTab('add1','institute/getList')">个人信息</a></li>
	            </ul>
	        </div>
	        <div title="系统管理">
	            <ul>
	            	<li><a onclick="addTab('学院管理','institute/getList')">学院管理</a></li>
	            	<li><a onclick="addTab('专业管理','major/getList')">专业管理</a></li>
	            	<li><a onclick="addTab('班级管理','institute/getAdd')">班级管理</a></li>
	            	<li><a onclick="addTab('学生管理','institute/getAdd')">学生管理</a></li>
	            </ul>
	        </div>
	    </div>
	</div>
	<div id="content" region="center">
		<div class="easyui-tabs" plain="true" id="tab1">
	       
	    </div>
	</div>
    <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script>
    	function addTab(title, url){
    		if ($('#tab1').tabs('exists', title)){
    			$('#tab1').tabs('select', title);
    		} else {
    			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;min-height:300px;"></iframe>';
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