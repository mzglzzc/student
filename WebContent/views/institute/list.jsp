<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>student list</title>
<%@include file="/views/include/common.jsp"%>
</head>
<body>
	<table id="tt" class="easyui-datagrid" style="" iconCls="icon-save" toolbar="#tb" url="getAll" pagination="true" rownumbers="true">
		<thead>
			<tr>
				<th field="id">ID</th>
				<th field="name">学院名称</th>
				<th field="ctime">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="javascript:alert('Add')">添加</a> 
	</div>
	
	
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
</body>
</html>
