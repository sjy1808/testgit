package com.tedu.jt.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

/**
 *负责根据商品的id修改商品信息 
 */
public class ProdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//0.处理请求参数乱码
		request.setCharacterEncoding("utf-8");
		//1.获取修改后的商品信息
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		double price=Double.parseDouble(request.getParameter("price"));
		int pnum=Integer.parseInt(request.getParameter("pnum"));
		String description=request.getParameter("description");
		
		//2.根据id修改商品信息
		updateProdById(id,name,category,price,pnum,description);
		//3.提示用户商品修改成功
		PrintWriter pw = response.getWriter();
		pw.write("<h1 style='color:blue;text-align:center'>");
		pw.write("商品信息修改成功! 3秒之后将会跳转到商品列表页面...");
		pw.write("</h1>");
		//4.定时刷新到商品的列表页面
		response.setHeader("Refresh","3;url="+request.getContextPath()+"/ProdListServlet");
	}
	/*根据id修改商品信息*/
	private void updateProdById(int id, String name, String category, double price, int pnum, String description) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接(从 连接池中获取)
			conn=JDBCUtils.getConn();
			
			//2.声明sql,获取传输器
			String sql="update product set name=?,category=?,price=?,pnum=?,description=? where id=?";
			ps=conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			ps.setInt(6, id);
			//4.执行sql语句
			ps.executeUpdate();//不要传sql参数!!
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品信息修改失败!");
		} finally {
			JDBCUtils.close(conn,ps,null);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
