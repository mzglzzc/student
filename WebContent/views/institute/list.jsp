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
		<a id="addBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<form action="" style="display:inline-block">
			<span>ID:</span>
			<input name="id" style="line-height:26px;border:1px solid #ccc">
			<span>学院名称:</span>
			<input name="searchname" style="line-height:26px;border:1px solid #ccc">
			<button type="submit" class="easyui-linkbutton" plain="true" >搜索</button>
		</form>
		
	</div>
	<div id="win" class="easyui-window" title="新增" closed="true" style="width:300px;">
		<form style="padding:10px 20px 10px 40px;" action="/student/institute/add" method="get">
			<p>学院名称: <input name="name" type="text"></p>
			<div style="padding:5px;text-align:center;">
				<button type="submit" class="easyui-linkbutton" icon="icon-ok">Ok</button>
				<a id="cancelBtn" href="#" class="easyui-linkbutton" icon="icon-cancel">Cancel</a>
			</div>
		</form>
	</div>Í
	
	<%@include file="/views/include/comjs.jsp"%>
   <script>
	   $('#addBtn').click(function(){
		   $('#win').window('open');
	   })
	   $('#cancelBtn').click(function(){
		   $('#insName').val('');
		   $('#win').window('close');
	   })
   </script>
</body>
</html>
