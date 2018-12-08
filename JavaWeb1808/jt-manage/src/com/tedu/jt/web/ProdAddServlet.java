package com.tedu.jt.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.jt.utils.JDBCUtils;

/**
 * 负责处理商品添加请求
 */
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//0.处理请求参数乱码(针对POST)
		request.setCharacterEncoding("utf-8");
		
		//1.获取要添加的商品信息
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		//String类型转换为double和int类型
		double price = Double.parseDouble(request.getParameter("price"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String description = request.getParameter("description");
		
		//2.通过JDBC程序将商品信息保存到数据库中
		addProd(name,category,price,pnum,description);
		
		//3.提示用户商品添加成功
		PrintWriter pw = response.getWriter();
		pw.write("<h1 style='color:blue;text-align:center'>");
		pw.write("商品添加成功! 3秒之后将会跳转到商品列表页面...");
		pw.write("</h1>");
		
		//4.定时刷新:3秒后跳转到商品列表页面
		response.setHeader("Refresh","3;url="+request.getContextPath()+"/ProdListServlet");
		
		
		
	}
	/*将商品信息保存到数据库中(jt_db.product)*/
	private void addProd(String name, String category, double price, int pnum, String description) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接(从 连接池中获取)
			conn=JDBCUtils.getConn();
			
			//2.声明sql,获取传输器
			String sql="insert into product values(null,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			//4.执行sql语句
			ps.executeUpdate();//不要传sql参数!!
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品添加失败!");
		} finally {
			JDBCUtils.close(conn,ps,null);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
