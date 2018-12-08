package com.tedu.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.cgb.utils.JDBCUtils;

/**连接数据库完成创建用户数据表格添加用户注册信息
 */
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理网页乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取regist.jsp注册表的数据并添加到数据库user表中
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		String email = request.getParameter("email"); 
		String cpnum = request.getParameter("cellphonenum");	
		System.out.println("username:"+username+"\n"
				+"password:"+password+"\n"				
				+"mail:"+email+"\n"
				+"verification:"+cpnum+"\n"
				);		
		RegistUser(username, password, email, cpnum);
		//response.getWriter().write("<p style='background:cyan;font-size:50px;color:red;'>注册成功，三秒之后跳转至登录界面</p>");
		response.getWriter().write("<script> function fn() { alert('注册成功，即将为您跳转至登录界面！');} fn(); </script>");
		response.setHeader("Refresh", "1;url="+request.getContextPath()+"/login.jsp");
		//request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	private void RegistUser(String username, String password, String email, String cpnum) {
		CreateUser();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConn();
			String sql = "insert into user values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, cpnum);
			ps.executeUpdate();
			System.out.println("注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("注册失败！");
		}
	}

	private void CreateUser() {
		Connection conn = null;
		Statement st = null;
		ComboPooledDataSource pool 
		= new ComboPooledDataSource();
		try {
			//连接数据库
			conn = pool.getConnection();
			//获取连接连接器
			st = conn.createStatement();
			//执行sql建立数据库shop并创建user表			
			st.addBatch("create table if not exists user(username varchar(20),password varchar(20),email varchar(20),cpnum varchar(20))");			
			//将批处理一次性发送到数据库中执行\
			st.executeBatch();
			System.out.println("创建成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建失败！");
		}finally {
			JDBCUtils.close(conn, st,null);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
