<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>日志列表页面</h1>
	<h2><%=new java.util.Date() %></h2>
	<div id="containerId">
		<table border="1" cellpadding="2" cellspacing="0" width="70%">
			<thead>
				<tr>
					<td>id</td>
					<td>username</td>
					<td>ip</td>
					<td>createdTime</td>
				</tr>
			</thead>
			<tbody id="tbodyId" align="center">
				<tr><td colspan="4">数据正在加载中...</td></tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		window.onload=function(){//设置dom状态监听 事件加载
			doGetObjects();
			console.log("main thread OK");
		}
		function doGetObjects(){
			//1.创建ajax请求对象(ajax应用的入口对象)
			//debugger
			var ajax=new XMLHttpRequest();
			//console.log("ajax",ajax);
			//2.设置状态监听(监听与服务器的通讯状态)
			ajax.onreadystatechange=function(){
				//console.log(ajax.onreadystatechange)
				if(ajax.readyState==4&&ajax.status==200){
					console.log(ajax.responseText);//responseText 输出响应结果,代表服务器响应的文本内容
					doHandleResponseResult(ajax.responseText);
				}
			}
			//3.发送请求
			doSendGetRequest(ajax);
			//doSendPostRequest(ajax);
			
		}
		function doSendGetRequest(ajax){
			//3.1执行open操作,打开连接
			var url="doFindPageObjects.do?pageCurrent=1";
			ajax.open("GET",url,true);//true表示异步,false表示同步
			//3.2执行请求发送
			ajax.send(null);//GET请求send方法内部不传数据
		}
		function doSendPostRequest(ajax){
			//3.1执行open操作,打开连接
			var url="doFindPageObjects.do";
			ajax.open("POST",url,true);
			//3.2执行请求发送
			//post请求必须设置此请求头
			ajax.setRequestHeader("Content-Type","application/x-wwww-form-urlencoded");
			ajax.send("pageCurrent=1");//post请求此位置传输数据
		}
		//4.处理响应结果
		function doHandleResponseResult(responseText){
			//1.获取tbody对象
			var tbody=document.getElementById("tbodyId");
			tbody.innerHTML="";
			//2.将json格式字符串转换json格式的js对象
			var result=JSON.parse(responseText);
			console.log("result",result);
			//3.将记录呈现在页面上
			//3.1获取result中的记录
			var records=result.data.records;
			//3.2迭代记录
			for(var i=0;i<records.length;i++){
				//3.2.1创建tr对象
				var tr=document.createElement("tr");
				//3.2.2创建td对象,并将td追加到tr中
				doCreateTd(tr,records[i].id);
				doCreateTd(tr,records[i].username);
				doCreateTd(tr,records[i].ip);
				doCreateTd(tr,records[i].createTime);
				//3.2.3将tr对象追加到tbody中
				tbody.appendChild(tr);
			}
			
		}
		function doCreateTd(tr,row){
			var td=document.createElement("td");
			td.innerText=row;
			tr.appendChild(td);
		}
	</script>
</body>
</html>