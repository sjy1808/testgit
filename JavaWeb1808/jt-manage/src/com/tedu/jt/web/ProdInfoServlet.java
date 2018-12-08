package com.tedu.jt.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

/**
 *根据商品id查询商品信息 
 */
public class ProdInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取商品的id
		int id=Integer.parseInt(request.getParameter("id"));
		//2.根据id查询商品信息,返回Product对象
		Product prod=findProdById(id);
		//3.将商品对象存入到request域中
		request.setAttribute("prod", prod);
		//4.通过转发将商品信息带到prod_upd.jsp进行回显
		request.getRequestDispatcher("/prod_upd.jsp").forward(request, response);
		
	}
	/*根据id查询商品信息*/
	private Product findProdById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product prod=null;
		try {
			//1.获取连接对象(从连接池中获取)
			conn=JDBCUtils.getConn();
			//2.声明sql语句,获取传输器对象
			String sql="select * from product where id=?";
			ps=conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setInt(1,id);
			
			//4.执行SQL语句并返回执行结果
			rs=ps.executeQuery();
			//5.处理结果(将ResultSet中的第一行记录转成一个Product对象)
			if(rs.next()){
				prod=new Product(id,
						rs.getString("name"),
						rs.getString("category"),
						rs.getDouble("price"),
						rs.getInt("pnum"),
						rs.getString("description"));
			}
			System.out.println("----"+prod);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品查询失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		
		
		
		return prod;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
