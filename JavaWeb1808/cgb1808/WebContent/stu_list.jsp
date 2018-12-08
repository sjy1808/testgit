<%@page import="java.util.List"%>
<%@page import="com.tedu.cgb.web.Student"%>
<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>学员信息表</TITLE>
<META content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/js/jquery-1.4.2.js"></script>
<STYLE type=text/css> 
	{
		FONT-SIZE: 12px
	}
	.gridView {
		BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New;
	}
	.gridViewHeader {
		BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid;LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid 
	}
	.gridViewItem {
		BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
	}
	.cmdField {
		BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(./images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
	}
	.buttonBlue {
		BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(./images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
	}
</STYLE>
</HEAD>
<BODY style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(./images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<SCRIPT type=text/javascript>
	var theForm = document.forms['aspnetForm'];
	if (!theForm) {
	    theForm = document.aspnetForm;
	}
	function __doPostBack(eventTarget, eventArgument) {
	    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
	        theForm.__EVENTTARGET.value = eventTarget;
	        theForm.__EVENTARGUMENT.value = eventArgument;
	        theForm.submit();
	    }
	}
</SCRIPT>
<DIV>
  	<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    	<TBODY>
      		<TR>
        		<TD width=10></TD>
        		<TD>
	        		<SPAN style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left;  PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px;TEXT-ALIGN: center; 0px: ">学员信息表 </SPAN>
	        	</TD>
      		</TR>
      		<TR>
        		<TD>&nbsp;</TD>
        		<TD style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" vAlign=top align=middle>
          			<DIV>
            			<TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all border=1>
              				<TBODY>
                				<TR>
                  					<TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  					<TH class=gridViewHeader scope=col>学号</TH>
                  					<TH class=gridViewHeader scope=col>班级</TH>
                  					<TH class=gridViewHeader scope=col>姓名</TH>
                  					<TH class=gridViewHeader scope=col>职位</TH>
                  					<TH class=gridviewHeader scope=col>详情信息</TH>
                  					<TH class=gridviewHeader scope=col>更新</TH>
                  					<TH class=gridviewHeader scope=col>删除</TH>
                				</TR>
                				<c:forEach items="${list }" var="stu">
                				<TR>
                  					<TD class=gridViewItem style="WIDTH: 50px"><IMG src="EmployeeMgr.files/bg_users.gif"> </TD>
				                  	<TD class=gridViewItem>${stu.getStudentId() }</TD>
				                  	<TD class=gridViewItem>${stu.getBanji()}</TD>
				                  	<TD class=gridViewItem>${stu.getName() }</TD>
				                  	<TD class=gridViewItem>${stu.getJob() }</TD>
				                  	<TD class=gridViewItem>
					                  	<A class=cmdField href="<%=request.getContextPath() %>/StudentInfoServlet?id=${stu.getId()}">查看详情</A></TD>
				                  	<TD class=gridViewItem>
					                  	<A class=cmdField href="<%=request.getContextPath() %>/StudentInfoServlet?id=${stu.getId()}">编辑</A></TD>
				                  	<TD class=gridViewItem>
					                  	<A class=cmdField id=ctl00_ContentPlaceHolder2_GridView1_ctl02_LinkButton1 onclick="return confirm('确定要删除吗？');" href="<%=request.getContextPath()%>/StudentDeleteServlet?id=${stu.id}">删除</A> </TD>
				               </TR>
				               </c:forEach>
              				</TBODY>
            			</TABLE>
          			</DIV>
        		</TD>
        	</TR>
    	</TBODY>
  	</TABLE>
</DIV>

</BODY>
</HTML>
