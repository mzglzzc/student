<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
	body {
      background:url("static/imgs/loginbk.png") #3D8BFF no-repeat;
      background-size:cover;
	  margin:0;
	  padding:0;
	}
	.lwrap{background-color:#fff;width:500px;margin:100px auto;padding:25px;outline:rgba(184,184,184,0.3) solid 10px;}
	.ltable{width:80%;}
	.ltable input[name="name"],input[name="pass"]{width:100%;height:35px;}
	.ltable td{padding:10px 0;}
	.lh1{color:#513DFF; margin: 6px; font-size: 1.5em; font-family: "微软雅黑"; font-weight: normal;}
</style>
<link rel="stylesheet" href="/student/static/font-awesome/css/font-awesome.min.css">
</head>
<body>
	<div class="lwrap">
		<form class="lform" action="form1_proc.php" method="get">
			<h1 class="lh1"><i class="icon-folder-open"></i>系统登录</h1>
			<table class="ltable">
				<tr>
					<td>账号:</td>
					<td><input name="name" type="text"></input></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input name="pass" type="password"></input></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>