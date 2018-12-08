package com.tedu.cgb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.cgb.utils.JDBCUtils;

/**
 * 负责添加学员信息
 */
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理相应参数乱码
		response.setContentType("text/html;charset=utf-8");
		//0.处理请求参数乱码
		request.setCharacterEncoding("utf-8");
		//1.获取要添加的学员信息
		String studentId=request.getParameter("studentId");
		String banji=request.getParameter("banji");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String job=request.getParameter("job");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2.通过JDBC程序将学生信息保存到数据库中
		addStudent(studentId,banji,name,gender,job,phone,qq,email,username,password);
		//3.提示教师添加成功
		PrintWriter pw = response.getWriter();
		pw.write("<h3 style='color:blue;text-align:center'>");
		pw.write("学生信息添加成功! 3秒之后将会跳转到学生信息列表页面...");
		pw.write("</h3>");
		//4.定时刷新,3秒之后跳转到学生信息列表
		response.setHeader("Refresh","3;url="+request.getContextPath()+"/StudentListServlet");
	}
	//将学生信息保存到数据库中(s1.stu)
	private void addStudent(String studentId, String banji, String name, String gender, String job, String phone,
			String qq, String email, String username, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//获取数据库连接
			conn=JDBCUtils.getConn();
			//声明sql,获取传输器
			String sql="insert into stu values(null,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//设置sql参数
			ps.setString(1,studentId);
			ps.setString(2,banji);
			ps.setString(3,name);
			ps.setString(4,gender);
			ps.setString(5,job);
			ps.setString(6,phone);
			ps.setString(7,qq);
			ps.setString(8,email);
			ps.setString(9,username);
			ps.setString(10,password);
			//执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败!");
		} finally {
			//释放资源
			JDBCUtils.close(conn, ps, null);
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
