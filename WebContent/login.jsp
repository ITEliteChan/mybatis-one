<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
<input type="hidden" name="method" >
用户名:<input type="text" name="userName">
密码:<input type="password" name="passWord"><br>
7天免登陆<input type="checkbox" name="keep7" value="seven"><br>
<input type="submit" value="登录">

</form>
</body>
</html>