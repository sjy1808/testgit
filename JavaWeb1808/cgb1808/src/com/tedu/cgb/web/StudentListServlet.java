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
import javax.servlet.http.HttpSession;

import com.tedu.cgb.utils.JDBCUtils;

/**
 * 负责查询出所有的商品信息,并带到jsp进行显示
 */
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.通过JDBC程序查询出所有的学生信息,返回一个List集合
		List<Student> list=findStuList();
		System.out.println("list:"+list);
		//2.将所有的学生的list集合存入request域中
		request.setAttribute("list", list);
		//3.通过转发将所有学生的list集合带到jsp显示
		request.getRequestDispatcher("/stu_list.jsp").forward(request, response);
	}
	//查询所有的商品信息
	private List<Student> findStuList() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Student> list=null;
		try {
			//获取连接
			conn=JDBCUtils.getConn();
			//声明sql,获取传输器
			String sql="select * from stu";
			ps=conn.prepareStatement(sql);
			//执行sql语句,返回执行结果
			rs=ps.executeQuery();
			//处理结果(将每一条记录转为一个Student对象,再将所有的Student对象存入到List集合中返回)
			list = new ArrayList();
			while(rs.next()){
				Student stu=new Student(
						rs.getInt("id"),
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
				list.add(stu);
				
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

