﻿<%@page pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>无标题页</TITLE>
<META content="text/html; charset=utf-8">
<STYLE type=text/css> 
	{
		FONT-SIZE: 25px
	}
</STYLE>
</HEAD>
<BODY style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(./images/bg.gif); BACKGROUND-REPEAT: repeat-x">
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
  		<TBODY>
    		<TR>
      			<TD width=10 height=29><IMG src="Left.files/bg_left_tl.gif"></TD>
      			<TD style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(./images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">主菜单</TD>
      			<TD width=10><IMG src="Left.files/bg_left_tr.gif"></TD>
    		</TR>     
  		</TBODY>
	</TABLE>
	<div id="menu_bar">
		<div style="BACKGROUND-IMAGE: url(./images/bg_left_ls.gif)"><a href="<%=request.getContextPath()%>/StudentListServlet" target="rightFrame">> 学员信息</a></div>
		<div style="BACKGROUND-IMAGE: url(./images/bg_left_ls.gif)"><a href="<%=request.getContextPath()%>/stu_add.jsp" target="rightFrame">> 添加学员</a></div>
		
	</div>	
</BODY>
</HTML>
