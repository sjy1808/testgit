package com.tedu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.util.JDBCUtil;

/**
 * 
 */
public class HWS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			/*//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据连接
			conn=DriverManager.getConnection("jdbc:mysql:///jt_db","root","");*/
			
			//1.获取连接
			conn=JDBCUtil.getConn();
			//3.获取传输器
			String sql="select * from account where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			//4.执行sql语句
			rs=ps.executeQuery();
			//5.处理执行结果
			if(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				double money=rs.getDouble("money");
				System.out.println(id+":"+name+":"+money+":");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询失败!");
		} finally {
			//6.释放资源
			JDBCUtil.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
