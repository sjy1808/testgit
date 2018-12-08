package com.tedu.cgb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.cgb.utils.JDBCUtils;

/*
 * Servlet接口
 * |--GenericServlet
 *    |--HttpServlet
 * */
public class StudentUdpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}




	// 处理POST请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); //处理响应正文乱码


		//1.获取修改后的商品信息
		int id=Integer.parseInt(request.getParameter("id"));
		String studentId=request.getParameter("studentId");
		String banji=request.getParameter("banji");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//2.根据id修改商品信息
		updateProdById( id, studentId,banji,name,gender,job,phone,qq,email,username,password);
		//3.提示用户修改成功
		PrintWriter pw = response.getWriter();
		pw.write("<h1 style='color:blue'>");
		pw.write("信息修改成功,两秒后将跳转到"+"学员列表页面");
		pw.write("</h1>");
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"/StudentListServlet");
		//4.定时刷新到学员列表页面

	}
	private void updateProdById(int id, String studentId, String banji, String name, String gender, String job,
			String phone, String qq, String email, String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {


			//1.获取连接（从连接池中获取）
			conn = JDBCUtils.getConn();
			//2.声明sql，获取传输器
			String sql = "update stu set studentId=? ,banji=?,name=?,gender=?,job=?,phone=?,qq=?,email=?,username=?,password=? where id=?;";
			ps = conn.prepareStatement(sql);
			//3.设置sql参数

			ps.setString(1, studentId);
			ps.setString(2, banji);
			ps.setString(3, name);
			ps.setString(4, gender);
			ps.setString(5, job);
			ps.setString(6, phone);
			ps.setString(7, qq);
			ps.setString(8, email);
			ps.setString(9,username);
			ps.setString(10,password);
			ps.setInt(11, id);
			//4.执行sql语句
			ps.executeUpdate();//不要传sql参数

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("信息修改失败！！");
		}finally{
			JDBCUtils.close(conn,ps,rs);
		}

	}


}

