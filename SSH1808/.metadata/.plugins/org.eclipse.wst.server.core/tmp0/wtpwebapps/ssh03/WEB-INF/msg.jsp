<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ValueStack</h1>
	<!-- OGNL表达式获取数据 -->
	<s:property value="message"/><br>
	<s:property value="[1].message"/>
	<s:property value="#session.loginName"/><br>
	<!-- EL表达式获取数据 -->
	${message }<br>
	${loginName }<br>
	<!-- 输出valueStack中的数据 -->
	<s:debug></s:debug>
</body>
</html>