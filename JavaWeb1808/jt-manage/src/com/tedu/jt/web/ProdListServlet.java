package com.tedu.jt.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

/**
 * 负责查询出所有的商品信息并带到JSP进行显示
 */
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.通过JDBC程序查询出所有的商品信息,返回一个List集合
		List<Product> list=findProdList();
		/*Iterator<Product> it = list.iterator();
		while(it.hasNext()){
			Product prod = it.next();
			System.out.println(prod.getId());
			System.out.println(prod.getName());
			System.out.println(prod.getCategory());
			System.out.println(prod.getPrice());
			System.out.println(prod.getPnum());
			System.out.println(prod.getDescription());
			
		}*/
		System.out.println("list---"+list);
		//2.将所有商品的list集合存入request域中
		request.setAttribute("list",list);
		//3.通过转发将所有商品的list集合带到JSP显示
		request.getRequestDispatcher("/prod_list.jsp").forward(request, response);
		
		//TODO 2.在Prod_list.jsp中取出list集合,将所有商品信息显示在JSP中
		
	}
	/*查询所有的商品信息*/
	private List<Product> findProdList() {
		/*Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list = new LinkedList<>();
		try {
			//1.获取连接对象(从连接池中获取)
			conn=JDBCUtils.getConn();
			//2.声明sql,获取传输器
			String sql="select * from product";
			ps=conn.prepareStatement(sql);
			//3.执行sql语句,返回执行结果
			rs=ps.executeQuery();
			4.处理结果集(将每一条记录转为一个Product对象,再将所有的Product对象存入到List集合中返回)
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				int pnum=rs.getInt("pnum");
				String description=rs.getString("description");
				Product prod = new Product(id,name,category,price,pnum,description);
				list.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询信息失败!");
		} finally {
			//5.释放资源
			JDBCUtils.close(conn, ps, rs);
		}
		return list;*/
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list=null;
		try {
			//1.获取连接对象(从连接池中获取)
			conn=JDBCUtils.getConn();
			//2.声明sql,获取传输器
			String sql="select * from product";
			ps=conn.prepareStatement(sql);
			//3.执行sql语句,返回执行结果
			rs=ps.executeQuery();
			/*4.处理结果集(将每一条记录转为一个Product对象,再将所有的Product对象存入到List集合中返回)*/
			list=new ArrayList();
			while(rs.next()){
				Product prod=new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("category"),
						rs.getDouble("price"),
						rs.getInt("pnum"),
						rs.getString("description"));
				list.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return list;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
