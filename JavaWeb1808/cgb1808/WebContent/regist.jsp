<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>学员信息</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; background:url(img/1.jpg) repeat 0px 0px;}
	h2{ text-align: center; }
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; width:50%;background:white; }
	td, th{ padding: 7px;font-size:18px;}
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	input,select,textarea{ width:284px; height:30px; background:#EDEDED; border:1px solid #999; text-indent:5px; font-size:18px; }
	input[type='submit']{ width:130px; height:36px; cursor:pointer; border-radius:5px 5px 5px 5px; background:#ddd; }
	select{text-indent:0px;}
	textarea{height:100px;font-size:22px;}
</style>

<!--引入jquery的js库-->
<script src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>欢迎注册</h2>
	<hr/>
	
	<form action="<%=request.getContextPath() %>/regist" method="POST" >
		<input type="hidden" name="id" value="${stu.id }"/>
		<table border="1">
			<tr>
				<td width="30%">学号</td>
				<td>
					<input type="text" name="studentId" value=""/>
				</td>
			</tr>
			<tr>
				<td>班级</td>
				<td>
					<input type="text" name="banji" value=""/>
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="name" value=""/>
				</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="text" name="gender" value=""/>
				</td>
			</tr>
			<tr>
				<td>职位</td>
				<td>
					<input type="text" name="job" value=""/>
				</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td>
					<input type="text" name="phone" value=""/>
				</td>
			</tr>
			<tr>
				<td>qq号</td>
				<td>
					<input type="text" name="qq" value=""/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input type="text" name="email" value=""/>
				</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" name="username" value=""/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input type="text" name="password" value=""/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit"  value="确认注册" />
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

