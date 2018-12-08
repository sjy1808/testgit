<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户登录...</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="stylish Sign in and Sign up Form A Flat Responsive widget, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<link href="css/style.css" rel='stylesheet' type='text/css' media="all" /><!--stylesheet-->
</head>
<body>
<h1>登录管理系统</h1>
<div class="form-w3ls">
	<div class="form-head-w3l">
		<h2>s</h2>
	</div>
    <ul class="tab-group cl-effect-4">
       <!--  <li class="tab active"><a href="#signin-agile"></a></li> -->
		<!-- <li class="tab"><a href="#signup-agile">Sign Up</a></li> -->        
    </ul>
    <div class="tab-content">
        <div id="signin-agile">   
			<form action="<%=request.getContextPath() %>/Login" method="post">
				
				<p class="header">用户名</p>
				<input type="text" name="username" placeholder="请输入用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'User Name';}" required="required">
				
				<p class="header">用户密码</p>
				<input type="password" name="password" placeholder="请输入密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				
				<br/>
				
				<input  type="submit" class="sign-in" value="立即登录"/>
				
			
			</form>
		</div>
		<!-- <div id="signup-agile">   
			<form action="#" method="post">
				<p class="header">User Name</p>
				<input type="text" name="user" placeholder="Your Full Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your Full Name';}" required="required">
				<p class="header">Email Address</p>
				<input type="email" name="email" placeholder="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="required">
				<p class="header">Password</p>
				<input type="password" name="password" placeholder="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="required">
				<p class="header">Confirm Password</p>
				<input type="password" name="password" placeholder="Confirm Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}" required="required">
				<input type="submit" class="register" value="Sign up">
			</form>
		</div> 
    </div>tab-content
</div> /form -->	  
<p style="color:darkgreen;"class="copyright">&copy; 2018 cn.tarena.com | <a style="color:darkblue;"href="regist.jsp" target="">没有账号立即注册?</a></p>
<!-- js files -->
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<!-- /js files -->
</body>
</html>