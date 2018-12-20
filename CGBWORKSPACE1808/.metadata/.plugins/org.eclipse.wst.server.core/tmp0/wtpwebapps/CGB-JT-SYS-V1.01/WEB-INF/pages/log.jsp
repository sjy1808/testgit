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
		<table border="1" cellpadding="2" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>id</th>
					<th>username</th>
					<th>createdTime</th>
				</tr>
			</thead>
			<tbody id="tbodyId" align="center">
				<tr><td colspan="3">数据正在加载中...</td></tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		//dom event (页面元素加载完成执行js函数)
		window.onload=function(){
			doGetObjects();
			console.log(" main thread OK");
		}
		function doGetObjects(){
			//debugger 断点调试法(浏览器需要处于调试状态)
			//1.创建ajax请求对象(ajax应用的入口对象)
			var xhr=new XMLHttpRequest();
			console.log("xhr",xhr);//在控制台输出
			//console.log("xhr="+xhr);//在控制台输出,这种方式是字符串
			//2.设置状态监听(监听与服务器的通讯状态)(观察者模式)
			xhr.onreadystatechange=function(){//callback:回调
				//4表示通讯状态结束
				//200表示服务器端响应OK
				if(xhr.readyState==4&&xhr.status==200){
					//输出响应结果(responseText 代表服务器响应的文本内容)
					console.log(xhr.responseText);
					doHandleResponseResult(xhr.responseText);
				}
			}
			//3.发送请求
			//doSendGetRequest(xhr);
			doSendPostRequest(xhr);
		}
		//发送get请求
		function doSendGetRequest(xhr){
			//3.执行open操作,打开连接
			var url="doFindPageObjects.do?pageCurrent=1";
			xhr.open("GET", url, true);//true表示异步,false表示同步
			//4.执行请求发送
			xhr.send(null);//GET请求send方法内部不传数据
			
		}
		//发送post请求
		function doSendPostRequest(xhr){
			//3.执行open操作,打开连接
			var url="doFindPageObjects.do";
			xhr.open("POST", url, true);//true表示异步,false表示同步
			//post请求必须设置此请求头
			  xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			//3.2.发送请求
			 xhr.send("pageCurrent=1");//post请求此位置传数据
		}
		//处理响应结果
		function doHandleResponseResult(responseText){
			//var div=document.getElementById("containerId");
			//div.innerHTML=responseText;
			//1.获取tbody对象
			var tBody=document.getElementById("tbodyId")
			tBody.innerHTML="";
			//2.将json格式字符串转换json格式的js对象
			var result=JSON.parse(responseText);//JsonResult
			console.log("result",result);
			//3.将记录呈现在页面上
			//3.1获取result中的记录
			var records=result.data.records;//PageObject对象中的records属性
			//3.2迭代记录
			for(var i=0;i<records.length;i++){
				//3.2.1 创建tr对象
				var tr=document.createElement("tr");
				//3.2.2 创建td对象,并将td追加tr中
				var td=document.createElement("td");
				td.innerText=records[i].id;
				tr.appendChild(td);
				
				var td=document.createElement("td");
				td.innerText=records[i].username;
				tr.appendChild(td);
				
				var td=document.createElement("td");
				td.innerText=records[i].createdTime;
				tr.appendChild(td);
				
				//3.2.3将tr对象追加tbody
				tBody.appendChild(tr);
			}
		}
		
	</script>
</body>
</html>