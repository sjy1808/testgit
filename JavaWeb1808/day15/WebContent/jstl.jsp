<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title></title>
</head>
<body>
	<h1>1.c:set标签</h1>
	<h3>(1)往域中添加属性</h3>
	<c:set var="name" value="张三丰" scope="request" />
	${ name }
	<h3>(2)修改域中已有的属性</h3>
	<c:set var="name" value="张无忌" scope="request" />
	${ name }
	
	
	<h1>2.c:if标签</h1>
	<c:if test="${45646+132131>987888 }">yes</c:if>
	<c:if test="${!(45646+132131>987888) }">no</c:if>
	
	<h1>3.c:forEach标签</h1>
	<h3>(1)遍历域中数组或集合中的元素</h3>
	<%
		String[] names={"王海涛","齐磊","陈子枢"};
		request.setAttribute("names", names);
		for(String name:names){
			
		}
	%>
	<c:forEach items="${ names }" var="name">
		${ name }
	</c:forEach>
	
	
	<h3>(2)遍历域中map集合中的元素</h3>
	<%
		Map map=new HashMap();
		map.put("name","关羽");
		map.put("age","45");
		map.put("addr","芯互联大厦");
		request.setAttribute("map", map);
	%>
	<c:forEach items="${ map }" var="entry">
	<%--entry能获取键值对 --%>
		${entry.key }:${entry.value }<br/>
	</c:forEach>
	
	
	<h3>(3)打印1~100之间的奇数,并指定间隔符号 </h3>
	step:步长 <br/>
	varStatus:用来封装循环遍历信息的对象,其中提供了一些属性:<br/>
		(1)first:boolean值表示当前被遍历的元素是不是第一个<br/>
		(2)last:boolean值表示当前被遍历的元素是不是最后一个<br/>
		(3)count:整数,表示当前被遍历的元素是第几个<br/><br/><br/><br/>
		
	<c:forEach begin="1" end="100" step="2" varStatus="status" var="i">
		${ i }${ status.last? "" : "," }
	</c:forEach>
	
	<h3>(4)打印1~100之间的奇数,并指定间隔符号,并将位置是3的倍数的数值指定颜色为红色</h3>
	<c:forEach begin="1" end="100" step="2" varStatus="status" var="i">
		
		<span ${status.count%3==0 ? "style='color:red'" : ""}>
			${ i }${ status.last? "" : "," }
		</span>
	</c:forEach>
	
	
	
</body>
</html>