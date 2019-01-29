<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="url" value="/login/login2.action" ></c:url>
<h1>${message}</h1>
 <form action="${url}" method="post">
 	<div><label>用户:</label>
 		<input type="text" name="user.name" />	
 	</div>
 	<div><label>密码:</label>
 		<input type="password" name="user.pwd" />	
 	</div>
 	<div><input type="submit" value="登录"/></div>
 </form>
</body>
</html>