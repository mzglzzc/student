<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>student list</title>
<%@include file="/views/include/common.jsp"%>
</head>
<body>
	<table id="tt" class="easyui-datagrid" style="" iconCls="icon-save" fit="true" 
		toolbar="#tb" url="/student/institute/getByCondition" pagination="true" rownumbers="true" method="get">
		<thead>
			<tr>
				<th field="id" checkbox="true"></th>
				<th field="insno">学院编号</th>
				<th field="name">学院名称</th>
				<th field="ctime">创建时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a id="addBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<a id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" >编辑</a>
		<a id="delBtn" class="easyui-linkbutton" iconCls="icon-cut" plain="true" >删除</a>
		<div style="display:inline-block">
			<span>学院编号:</span>
			<input id=insno name="insno" style="line-height:26px;border:1px solid #ccc">
			<span>学院名称:</span>
			<input id="searchname" name="searchname" style="line-height:26px;border:1px solid #ccc">
			<a class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
		</div>
	</div>
	<div id="win" class="easyui-window" title="新增" closed="true" style="width:300px;">
		<form id="add_form" style="padding:10px 20px 10px 40px;" action="/student/institute/add" method="get">
			<p>学院名称:<input id="name_add" name="name" type="text"></p>
			<p>学院编号:<input id="insno_add" name="insno" type="text"></p>
			<div style="padding:5px;text-align:center;">
				<button type="button" class="easyui-linkbutton" icon="icon-ok" onclick="checkValue()">确定</button>
				<a id="cancelBtn" href="#" class="easyui-linkbutton" icon="icon-cancel">取消</a>
			</div>
		</form>
	</div>
	<div id="edit_div" class="easyui-window" title="修改" closed="true" style="width:300px;">
		<form id="edit_form" style="padding:10px 20px 10px 40px;" action="/student/institute/add" method="get">
			<p>学院名称:<input id="name_edit" name="name" type="text"></p>
			<p>学院编号:<label id="insno_edit" name="insno"></p>
			<div style="padding:5px;text-align:center;">
				<button type="button" class="easyui-linkbutton" icon="icon-ok" onclick="checkName()">确定</button>
				<a id="cancelBtn2" href="#" class="easyui-linkbutton" icon="icon-cancel">取消</a>
			</div>
		</form>
	</div>
	<%@include file="/views/include/comjs.jsp"%>
	<script>
		$('#addBtn').click(function(){
			$('#win').window('open');
		})
		$('#editBtn').click(function(){
			var cks = $('#tt').datagrid('getSelections');
			if(cks==null || cks.length!=1){
				alert("请选择一条记录");
			} else {
				$("#name_edit").val(cks[0].name);
				$("#insno_edit").html(cks[0].insno);
				$('#edit_div').window('open');
			}
		})
		$('#delBtn').click(function(){
			var ids = [];
			var rows = $('#tt').datagrid('getSelections');
			for(var i=0; i<rows.length; i++){
				ids.push(rows[i].id);
			}
			location.href="/del?ids="+ids.join();
		})
		$('#cancelBtn').click(function(){
			$('#win').window('close');
		})
		$('#cancelBtn2').click(function(){
			$('#edit_div').window('close');
		})
		function doSearch(){
			$('#tt').datagrid('load',{
				insno: $('#insno').val(),
				name: $('#searchname').val()
			});
		}
		function checkValue(){
			var name = $("#name_add").val();
			var insno = $("#insno_add").val();
			if(name==null || name.trim().length<=0 || insno==null || insno.trim().length<=0){
				alert("名称和编号不能为空");
			} else {
				$.ajax({
					url:"/student/institute/checkValue",
					data:{"name":name,"insno":insno},
					dataType:"script",
					success:function(){
						if(isUnique){
							$("#add_form").submit();
						} else {
							alert("名称或编号已存在");
						}
					}
				});
			}
		}
		function checkName(){
			var name = $("#name_edit").val();
			if(name==null || name.trim().length<=0){
				alert("名称不能为空");
			} else {
				$.ajax({
					url:"/student/institute/checkName",
					data:{"name":name},
					dataType:"script",
					success:function(){
						if(isNameUnique){
							$("#edit_form").submit();
						} else {
							alert("名称已存在");
						}
					}
				});
			}
		}
	</script>
</body>
</html>
