package com.tedu.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.cgb.utils.JDBCUtils;

/**
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		//处理网页乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//获取regist.jsp注册表的数据并添加到数据库user表中
				String username = request.getParameter("username");
				String password = request.getParameter("password");		
			/*	System.out.println("username:"+username+"\n"
						+"password:"+password+"\n"		
						);		*/
				UserLogin(username, password, request,response);
				//response.getWriter().write("<p style='background:cyan;font-size:50px;color:red;'>注册成功，三秒之后跳转至登录界面</p>");
				//response.setHeader("Refresh", "1;url="+request.getContextPath()+"/login.jsp");
				//request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}

			private void UserLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {

				Connection conn =null;
				PreparedStatement ps = null;
				ResultSet rs =null;
				try {
					conn = JDBCUtils.getConn();			
					String sql = "select * from stu where username =? and password =? ";
					ps = conn.prepareStatement(sql);
					//设置sql参数
					ps.setString(1, username);
					ps.setString(2, password);
					System.out.println(sql);
					//执行sql语句返回执行结果
					rs = ps.executeQuery();//不传参数！
					//	rs = stat.executeQuery(sql);
					if(rs.next()){
						response.getWriter().write("<script> function fn() { alert('登录成功！');} fn(); </script>");
						response.setHeader("Refresh", "1;url="+request.getContextPath()+"/index.jsp");

					}else{			
					//	System.out.println("用户名或密码错误！");
						response.getWriter().write("<script> function fn() { alert('用户名或密码错误，请重新登录！');} fn(); </script>");
						//request.getRequestDispatcher("/login.jsp").forward(request, response);
						response.setHeader("Refresh", "1;url="+request.getContextPath()+"/login.jsp");
					}
		 		} catch (Exception e) {
					System.out.println("登录失败！");
					e.printStackTrace();
				}finally{
					JDBCUtils.close(conn, ps, rs);
				}	
			}

	}
