﻿<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<HTML>
<HEAD id=Head1>
<TITLE>无标题页</TITLE>
<META content="text/html; charset=utf-8">
<STYLE type=text/css> 
*{
	FONT-SIZE: 12px; COLOR: white
}
#logo {
	COLOR: white
}
#logo A {
	COLOR: white
}
FORM {
	MARGIN: 0px
}
#top{
	color:#FFFFFF;
	letter-spacing: 5px;
	text-shadow: 5px 5px 5px #000;
	margin:30px;
	font-size:35px;
}
</STYLE>
<SCRIPT src="Top.files/Clock.js" type=text/javascript></SCRIPT>
</HEAD>
<BODY style="BACKGROUND-IMAGE: url(./images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
<form id="form1">
    <SPAN style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 30%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(./images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right;">
		<A id=HyperLink2 href="index.jsp" target="_top">返回首页</A> 
		<IMG src="Top.files/menu_seprator.gif" align=absMiddle> 
		<A id=HyperLink3 href="login.jsp" target="_top">退出系统</A>
	</SPAN>
	<span id="top" margin="25px">学员信息管理系统</span> 
    <DIV style="DISPLAY: block; HEIGHT: 54px"></DIV>
    <DIV style="BACKGROUND-IMAGE: url(./images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
    	<TABLE cellSpacing=0 cellPadding=0 width="100%">
        	<TBODY>
          		<TR>
            		<TD>
              			<DIV><IMG src="Top.files/nav_pre.gif" align=absMiddle>
	            		<span style="font-size:15px">欢迎登录CGB1808学员信息管理系统</span>  
	          			</DIV>
            		</TD>
            		<TD align=right width="70%"> 
      					<IMG src="Top.files/menu_seprator.gif" align=absMiddle> 
	      				<SPAN id=clock></SPAN></SPAN>
	      			</TD>
          		</TR>
        	</TBODY>
      	</TABLE>
    </DIV>

  	<SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
	</SCRIPT>
</form>
</BODY>
</HTML>