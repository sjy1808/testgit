package com.tedu.cgb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.cgb.utils.JDBCUtils;


/**
 * 负责删除学生的信息
 */
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取所要删除的学生信息的id
		int id=Integer.parseInt(request.getParameter("id"));
		//2.根据id删除指定的学生信息
		deleteStudentById(id);
		//3.提示教师学生信息删除成功
		PrintWriter pw=response.getWriter();
		pw.write("<h3 style='color:bule;text-align:center'>");
		pw.write("信息删除成功! 3秒之后将跳转到学生信息列表页面...");
		pw.write("</h3>");
		//4.定时刷新:3秒后跳转到学生信息列表
		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/StudentListServlet");
	}

	private void deleteStudentById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//1.获取连接器
			conn=JDBCUtils.getConn();
			//2.声明sql,获取传输器
			String sql="delete from stu where id=?";
			ps=conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setInt(1, id);
			//4.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("学生信息删除失败!");
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
