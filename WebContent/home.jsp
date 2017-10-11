<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
登录人:${up.userName }
<hr>
<table width="800">
<c:forEach var="u" items="${userInfo }">
<tr>
<td>${u.userId}</td>
<td>${u.userName }</td>
<td>${u.passWord }</td>
<td>
<a href="UserServlet?method=pupdate&userId=${u.userId }">修改</a>
<a href="UserServlet?method=delete&userId=${u.userId }">删除</a>
</td>
</tr>
</c:forEach>
</table>
<a href="add.jsp">添加</a>

</body>
</html>