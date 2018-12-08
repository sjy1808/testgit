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
	<h1>1.EL表达式</h1>
	<h3>(1)EL可以获取常量/变量/表达式</h3>
	${154.123 }<br/>
	${'a' }<br/>
	${456*456 }<br/>
	${456+456 }<br/>
	${--456 }<br/>
	${456>2 }<br/>
	${"skfjiwe" }<br/>
	<% String name="深刻的九分裤";
		request.setAttribute("name", name);
	%>
	${name}
	<h3>(2)EL可以获取域中的数组或集合中的数据</h3>
	<% 
		
		int[] a={45,1,5,15,64,51,646,5,45,45};
		request.setAttribute("a", a);
		
	%>
	${a[2]}
	<h3>(3)EL可以获取域中的Map集合中的数据</h3>
	<%
		Map map=new HashMap();
		map.put("看等级积分","ajfjkaf");
		map.put("看等级积分1","ajfjkaf1");
		map.put("看等级积分2","ajfjkaf2");
		map.put("看等级积分3","ajfjkaf3");
		request.setAttribute("map",map);
	%>
	${map.看等级积分 }
	
	<h1>2.c:set标签</h1>
	<h3>(1)往域中添加属性</h3>
	<c:set var="name1" value="大结局" scope="request" />
	${name1 }
	<c:set var="sd" value="放得开链接" scope="session" />
	${sd }
	<h3>(2)c:if标签</h3>
	<c:if test="${55==55 }">yes</c:if>
	<c:if test="${!(55==55) }">no</c:if>
	
	<%--作业 --%>
	<c:set var="str" value="Hello" scope="request"/>
	${srt}
	<c:set var="str" value="Hello JSTL" scope="request"/>
	${str}
	<%
		Map map1=new HashMap();
		map1.put("nickname","的空间发的");
		map1.put("name","京东方");
		map1.put("age","23");
		request.setAttribute("map1", map1);
	%>
	${map1.nickname }
	${map1.name}
	<c:set target="${map1}" property="name" value="打客服"/>
	<c:set target="${map1}" property="nickname" value="的解放军"/>
	${map1.nickname }
	${map1.name}
	<hr/>
	<%
		String[] nickname={"点击付款","基督教","呵护","积分积分多少","登记号房间号"};
		session.setAttribute("nickname", nickname);
	%>
	<c:forEach items="${nickname }" var="i">
		${i}<br/>
	</c:forEach>
	<%
		Map map2=new HashMap();
		map2.put("name", "大姐夫");
		map2.put("age","26");
		map2.put("addr","北京");
		map2.put("job","java高级工程师");
		pageContext.setAttribute("map2", map2);
	%>
	<c:forEach items="${map2}" var="entry">
		${entry.key}:${entry.value}<br/>
	</c:forEach>
	
	<c:forEach begin="51" end="200" step="2" var="i" varStatus="status">
		${i}${status.last?"":","}
	</c:forEach>
	<c:forEach begin="51" end="200" step="2" var="i" varStatus="status">
		<span ${status.count%5==0?"style='color:red'":""} >
			${i}${status.last?"":","}
		</span>
	</c:forEach>
	
</body>
</html>