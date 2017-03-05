<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
<style type="text/css">
	body {
      background:url("static/imgs/loginbk.png") #3D8BFF no-repeat;
      background-size:cover;
	  margin:0;
	  padding:0;
	}
	.lwrap{background-color:#fff;width:500px;margin:100px auto;padding:25px;outline:rgba(184,184,184,0.3) solid 10px;}
	.ltable{width:80%;}
	.ltable input[name="name"],input[name="password"]{width:100%;height:35px;}
	.ltable td{padding:10px 0;}
	.lh1{color:#513DFF; margin: 6px; font-size: 1.5em; font-family: "微软雅黑"; font-weight: normal;}
	
</style>
<link rel="stylesheet" href="/student/static/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="/student/static/jquery-easyui-1.5.1/jquery.min.js"></script>
</head>
<body>
	<div class="lwrap">
		<form class="lform" action="login" method="get">
			<h1 class="lh1"><i class="icon-user"></i>&nbsp;登录</h1>
			<table class="ltable">
				<tr>
					<td colspan="2" style="color:red;">${message}</td>
				</tr>
				<tr>
					<td>身份：</td>
					<td>
						<span class="radioSpan">
							<input type="radio" name="identity" value="0" checked="true">学生</input>
							<input type="radio" name="identity" value="1">教师</input>
						</span>
					</td>
				</tr>
				<tr>
					<td>账号:</td>
					<td><input id="name" name="name" type="text" value="${name}"></input></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input id="password" name="password" type="password"></input></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" onclick="login()" value="登录"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	function login(){
		var identity = $("input[name=identity]:checked").val();
		var name = $.trim($("#name").val());
		var password = $("#password").val();
		console.log()
		if(name==null || name.length<=0 || password==null || password.length<=0){
			alert("用户名和密码不能为空");
			return false;
		} else if(name.length>20 || password.length>20){
			alert("用户名和密码的长度不能超过20字符");
			return false;
		}
	}
	</script>
</body>
</html>