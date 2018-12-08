package com.tedu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.util.JDBCUtil;

public class FilterDemo2 implements Filter{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter实例创建了!");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo2");
		//0.处理请求参数乱码
		request.setCharacterEncoding("utf-8");
		//0.处理响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取用户名
		String username1=request.getParameter("code");
		
		//2.获取数据库内的用户名判断是否与数据内的用户名一致
		query();
		try {
			while(rs.next()){
				String username=rs.getString("username");
				System.out.println(username);
				if(username1.equals(username)){
					chain.doFilter(request, response);
				}else {
					response.getWriter().write("<h1 style='color:blue;'>输入错误!</h1>");
					//>>定时刷新,3秒之后跳转到暗号输入界面
					HttpServletResponse res=(HttpServletResponse) response;
					HttpServletRequest req=(HttpServletRequest) request;
					
					//res.setHeader("Refresh", "3;url=/day16/code.html");
					res.setHeader("Refresh", "3;url="+req.getContextPath()+"/code.html");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("失败!");
		} 
	}

	private void query() {
		
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jt_db",
					"root",
					"");*/
			conn=JDBCUtil.getConn();
			String sql="select * from user where id =?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			
			rs=ps.executeQuery();
			
			//return rs;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败!");
		} finally {
			//JDBCUtil.close(conn, ps, null);
		}
		//return null;
		
	}

	@Override
	public void destroy() {
		System.out.println("Filter实例销毁了!");
		JDBCUtil.close(conn, ps, rs);
	}

}
