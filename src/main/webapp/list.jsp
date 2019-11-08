<%@ page language="java" contentType="text/html; charset=utf8"
    import="util.Pager,entity.Account,java.util.List"
	pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>列出账号</title>
</head>
<body>
	<h3 align="center">账号信息</h3>
	<hr color="red">
	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>余额</th>
			</tr>
			<c:forEach items="${pager.data}" var="act">
				<tr>
					<td>${act.id}</td>
					<td>${act.name}</td>
					<td>${act.balance}</td>
				</tr>
			</c:forEach>
		</table>	
		<ul style="list-style:none;display:flex;justify-content:space-around;width:200px">
			<li><a href="#">&lt;&lt;</a></li>
			<c:forEach var="index" begin="1" end="${pager.total }">
			<li><a href="listacts?pageNo=${index}&pageSize=5">${index }</a></li>
			</c:forEach>
			<li><a href="#">&gt;&gt;</a></li>
		</ul>	
		<span>总页数:${pager.total}，每页 5 条数据</span>
	</center>
</body>
</html>

<%-- 
	<%@指令名字  perperty1=value1  perperty2=value2 ... %>  ---- JSP指令 
	<%@page %> 页面指令，可以导入包  <%@taglib %> 可以引入标签库
	${acts}   <==> List<Account> acts = request.getAttribute("acts");
	${act.id}  <==>  act.getId();
	引入标签库的步骤：
	     1.  pom.xml 中引入相应的jstl.jar  :  jsp standard tag library
	     2.  在jsp页面中利用标签指令引入相应的标签
	         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	     3.  使用相应的标签
	     	 <c:forEach></c:forEach>   <c:if></c:if> 	
	实现前一页，后一页 
--%>