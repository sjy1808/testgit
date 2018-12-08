package com.tedu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet接口
 * 		|-- GenericServlet
 * 				|-- HttpServlet
 */
public class FirstServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//处理GET请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		/*
		 * 当浏览器请求当前Servlet时,将代表当前时间的字符串响应给浏览器
		 */
		//获取表示当前时间的字符串
		Date date=new Date();
		String dateStr=date.toLocaleString();
		//获取一个输出流
		PrintWriter writer = resp.getWriter();
		//注意:写中文会出现乱码,所以先不要写中文
		writer.write(dateStr);
		
		
	}
	//处理POST请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
