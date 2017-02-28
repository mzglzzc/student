<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>student list</title>
<%@include file="common.jsp"%>
</head>
<body>
	<table id="tt" class="easyui-datagrid" iconCls="icon-save" toolbar="#tb" url="institute/getAll">
		<thead>
			<tr>
				<th field="id">ID</th>
				<th field="name">姓名</th>
				<th field="ctime">入学时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="stuAdd" class="easyui-linkbutton" iconCls="icon-add" plain="true">Add</a> 
	</div>
	
	
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
</body>
</html>