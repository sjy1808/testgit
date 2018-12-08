package com.tedu.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从数据库中查询ID为1的记录
		int id=1;
		String name="tony";
		double money=1000;
		//id,name,money被快递的东西
		
		//request(快递箱):将数据存入Request域中
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("money", money);
		
		//转发:将请求转发到JSP,让JSP来处理及展示结果
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
		
		/*//将查询出的结果响应给浏览器
		PrintWriter pw = response.getWriter();
		pw.write("<p>id:"+id+"</p>");
		pw.write("<p>name:"+name+"</p>");
		pw.write("<p>money:"+money+"</p>");*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
