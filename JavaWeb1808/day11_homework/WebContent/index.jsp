<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	#id{text-align:center;font-size:100px}
</style>
</head>
<body>
	<div id="a1">
	用户名:<%=request.getAttribute("username") %><br/>
	密码:<%=request.getAttribute("password") %><br/>
	昵称:<%=request.getAttribute("nickname") %><br/>
	自我描述:<%=request.getAttribute("desc") %><br/>
	</div>
</body>
</html>