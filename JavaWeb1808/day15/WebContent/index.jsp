<%@page import="java.util.Date"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title></title>
</head>
<body>
	<h1>1.JSP表达式</h1>
		<%--当前时间:<%=new Date().toLocaleString() %><br/> --%>
		<%="Hello JS~~~" %><br/>
		<%=4564+464+489 %><br/>
		<%=465 %><br/>
	
	<h1>2.JSP脚本片段</h1>
	<%
		String name="张飞";
		System.out.println(name);
	%>
	<%
		for(int i=0;i<50;i++){
			out.write("Hello JSP~~<br/>");
		}
	%>
	<hr/>
	
	<% for(int i=0;i<5;i++){ %>
		Hello JSP~~<br/>
	<% } %>
	
	<%--JSP的九大隐士对象 --%>
	<%
		
		
	%>
	<%=request.getContextPath() %><br/>
	<%--${pageContext.getRequest().getContextPath()} --%>
	${pageContext.request.contextPath }
	
	
	
	
	
	
	
</body>
</html>