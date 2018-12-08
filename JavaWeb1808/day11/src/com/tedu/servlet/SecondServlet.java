package com.tedu.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //处理GET请求(因为dopost调用了doGet,所以这里也处理POST请求)
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet实例创建了!");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("Hello..."+new Date().toLocaleString());
	}
	//处理POST请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("Servlet实例销毁了!");
	}
}
