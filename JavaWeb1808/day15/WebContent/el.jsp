<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title></title>
</head>
<body>
	<h1>1.EL表达式</h1>
	<h3>(1)EL可以获取常量/变量(必须存入域中)/表达式</h3>
	${"Hello EL" }<br/>
	${46541+546 }<br/>
	<% String name="阿凡达";
		request.setAttribute("name", name);
	%>
	<%--${name} 从四大域中寻找名称为name的属性值在寻找时按照域的大小,从小到大的顺序去查找!!
	找到就直接输出属性值,找不到就什么也不输出!!
	pageContext<request<session<application --%>
	${name }
	
	<h3>(2)EL可以获取域中的数组或集合中的数据</h3>
	<%
		String[] names={"王海涛","齐磊","陈子枢"};
		request.setAttribute("names", names);
	%>
	${ names[0] }
	${ names[1] }
	${ names[2] }
	
	<h3>(3)EL可以获取域中的Map集合中的数据</h3>
	<%
		Map map=new HashMap();
		map.put("name","关羽");
		map.put("age","45");
		map.put("addr","芯互联大厦");
		request.setAttribute("map", map);
	%>
	${map["name"] }
	${map["age"] }
	${map["addr"] }
	
	${map.name }
	${map.age }
	${map.addr }
	
	
</body>
</html>