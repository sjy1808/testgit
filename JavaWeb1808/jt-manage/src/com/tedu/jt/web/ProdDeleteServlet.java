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

import com.tedu.jt.utils.JDBCUtils;

/**
 * 根据商品id删除指定的商品信息
 */
public class ProdDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理响应正文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//1.获取所要删除商品的id
		int id=Integer.parseInt(request.getParameter("id"));
		//2.根据id删除指定的商品
		deleteProdById(id);
		//3.提示用户商品删除成功
		PrintWriter pw = response.getWriter();
		pw.write("<h1 style='color:blue;text-align:center'>");
		pw.write("商品删除成功! 3秒之后将会跳转到商品列表页面...");
		pw.write("</h1>");
		//4.定时刷新:3秒后跳转到商品的列表页面
		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/ProdListServlet");
		
	}

	private void deleteProdById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接器
			conn=JDBCUtils.getConn();
			//2.声明sql,获取传输器
			String sql="delete from product where id=?";
			ps=conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setInt(1, id);
			//4.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品删除失败!");
		} finally {
			//5.释放资源
			JDBCUtils.close(conn, ps, null);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
