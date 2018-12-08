<%@page import="java.util.List"%>
<%@page import="com.tedu.jt.web.Product"%>
<%@page pageEncoding="utf-8"%>
<!-- 需要通过taglid指令引入JSTL标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>商品管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center; }
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px }
	td, th{ padding: 7px;}
	th{ background-color: #DCDCDC; width:120px; }
	th.desc{ width: 500px; }
	hr{ margin-bottom:20px; border:1px solid #aaa; }
</style>

<!--引入jquery的js库-->
<script src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>商品管理</h2>
	<hr/>
	<table border="1">
		<tr>
			<th>商品ID</th>
			<th>商品名称</th>
			<th>商品种类</th>
			<th>商品单价</th>
			<th>库存数量</th>
			<th class="desc">描述信息</th>
			<th>操 作</th>
		</tr>

		<!-- 模版数据 -->
		
		<%--	
			System.out.println("jsp"+request.getAttribute("list")); 
			List<Product> list=(List)request.getAttribute("list"); 
			for(Product prod:list){
				System.out.println(prod.getId()+":"+prod.getName());
			}
		--%>
		<c:forEach items="${list}" var="prod">
		<tr>
			<td>${prod.getId() }</td>
			<td>${prod.getName() }</td>
			<td>${prod.getCategory() }</td>
			<td>${prod.getPrice() }</td>
			<td>
				${prod.getPnum() }
			</td>
			<td>${prod.getDescription() }</td>
			<td>
				<a id="delProd" href="<%=request.getContextPath()%>/ProdDeleteServlet?id=${prod.id}">删除</a> |
				<a id="updProd" href="<%=request.getContextPath()%>/ProdInfoServlet?id=${prod.id}">修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>



