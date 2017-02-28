<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>student list</title>
<%@include file="common.jsp"%>
</head>
<body>
	<table id="tt" class="easyui-datagrid" iconCls="icon-save" toolbar="#tb">
		<thead>
			<tr>
				<th field="itemid">姓名</th>
				<th field="productid">性别</th>
				<th field="listprice">年龄</th>
				<th field="unitcost">班级</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="javascript:alert('Add')">Add</a> 
	</div>
	
	
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
</body>
</html>
