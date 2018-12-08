package com.tedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class Third extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jt_db",
					"root",
					"");
			stat=conn.createStatement();
			String sql="select * from account";
			rs=stat.executeQuery(sql);
			int id=0;
			String name="";
			double money=1.0;
			while(rs.next()){
				id=rs.getInt("id");
				name=rs.getString("name");
				money=rs.getDouble("money");
				System.out.println(id+name+money);
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<p>id:"+id+"</p>");
			response.getWriter().write("<p>name:"+name+"</p>");
			response.getWriter().write("<p>money:"+money+"</p>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询失败!");
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} finally {
					rs=null;
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					stat=null;
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					conn=null;
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
