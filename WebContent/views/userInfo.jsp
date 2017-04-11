<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生管理系统</title>
    <%@include file="/views/include/common.jsp"%>
	<%@include file="/views/include/comjs.jsp"%>
	<style type="text/css">
		/* table {border-right:1px solid; border-bottom:1px solid;text-align:center;font-size:20px;}
		table th {border-left:1px solid;border-top:1px solid;padding:5px;}
		table td {border-left:1px solid;border-top:1px solid;} */
	</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'west'" style="width:30%;">
    	<div id="userInfo" class="easyui-layout" fit="true"></div>
	    
	    
    </div>
    <div data-options="region:'center',title:'公告'" style="padding:5px;"></div>
    <script type="text/javascript">
    $(function(){
    	$("#userInfo").layout('add',{
    		region:'west',
    		title:'个人信息',
    		content:'<table id="pg" class="easyui-propertygrid" style="width:100%" data-options="url:\'getUserInfo\',method:\'get\',showHeader:false,showGroup:true,scrollbarSize:0"></table>',
    		split:true,
    		collapsible:false,
    		tools:[
    			{
    				iconCls:'icon-edit',
    				handler:function(){
    					alert('add');
    				}
    			}
    		]
    	});
    });
    </script>
</body>
</html>