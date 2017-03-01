<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专业管理</title>
<%@include file="/views/include/common.jsp"%>
</head>
<body>
	<table id="tt" class="easyui-datagrid" style="" iconCls="icon-save" 
		toolbar="#tb" url="getByCondition" pagination="true" rownumbers="true" method="get">
		<thead>
			<tr>
				<th field="id">ID</th>
				<th field="name">专业名称</th>
				<th field="instituteName">所属学院</th>
				<th field="ctime">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a id="addBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<div style="display:inline-block">
			<span>ID:</span>
			<input id="id" name="id" style="line-height:26px;border:1px solid #ccc">
			<span>专业名称:</span>
			<input id="searchname" name="searchname" style="line-height:26px;border:1px solid #ccc">
			<a class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
		</div>
		
	</div>
	<div id="win" class="easyui-window" title="新增" closed="true" style="width:300px;">
		<form style="padding:10px 20px 10px 40px;" action="add" method="get">
			<p>专业名称: <input name="name" type="text"></p>
			<p>所属学院: <input id="cc" class="easyui-combobox" name="instituteid" data-options="valueField:'id',textField:'name',url:'../institute/getByCondition',method:'get'"></p>
			<div style="padding:5px;text-align:center;">
				<button type="submit" class="easyui-linkbutton" icon="icon-ok">确定</button>
				<a id="cancelBtn" href="#" class="easyui-linkbutton" icon="icon-cancel">取消</a>
			</div>
		</form>
	</div>
	
	<%@include file="/views/include/comjs.jsp"%>
   <script>
		$('#addBtn').click(function(){
			$('#win').window('open');
		})
		$('#cancelBtn').click(function(){
			$('#insName').val('');
			$('#win').window('close');
		})
		function doSearch(){
			$('#tt').datagrid('load',{
				ids: $('#id').val(),
				name: $('#searchname').val()
			});
		}
   </script>
</body>
</html>
