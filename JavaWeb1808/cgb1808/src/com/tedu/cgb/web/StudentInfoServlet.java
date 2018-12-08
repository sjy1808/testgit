package com.tedu.cgb.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.cgb.utils.JDBCUtils;

/**
 * 负责查询学生的详细信息
 */
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//1.通过JDBC程序查询出学生的详细信息,返回一个List集合
				int id=Integer.parseInt(request.getParameter("id"));
				Student stu=findStuList(id);
				
				//2.将所有的学生的信息list集合存入request域中
				request.setAttribute("stu", stu);
				//3.通过转发将学生的list集合带到jsp显示
				request.getRequestDispatcher("/stuinfo.jsp").forward(request, response);
			}
			//查询所有的商品信息
			private Student findStuList(int id) {
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					//获取连接
					conn=JDBCUtils.getConn();
					//声明sql,获取传输器
					String sql="select * from stu where id=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, id);
					//执行sql语句,返回执行结果
					rs=ps.executeQuery();
					//处理结果(将每一条记录转为一个Student对象,再将所有的Student对象存入到List集合中返回)
					Student stu = null;
					while(rs.next()){
						stu=new Student(
								id,
								rs.getString("studentId"),
								rs.getString("banji"),
								rs.getString("name"),
								rs.getString("gender"),
								rs.getString("job"),
								rs.getString("phone"),
								rs.getString("qq"),
								rs.getString("email"),
								rs.getString("username"),
								rs.getString("password"));
						return stu;
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("查询失败!");
				} finally {
					JDBCUtils.close(conn, ps, rs);
				}
				return null;
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

