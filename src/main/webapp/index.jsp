<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>转账功能</title>
</head>
<body>
	<h3 align="center">转账功能</h3>
	<hr color = "read">
	<center>
	<form action="transfer" method="get">
		转账账号：<input type="text" name="fromId"><br>
		被转账账号：<input type="text" name="toId"><br>
		金额：<input type="text" name="money"><br>
		<input type="submit" value="转账">
	</form>
	</center>
</body>
</html>
<!-- 
    jsp+servlet+javabean
	1.表现层的代码：页面
	2.servlet做控制：转发请求和跳转页面
	3.后台代码：Service和Dao层的代码
	
 -->