package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request功能三:实现请求转发和域对象
 */
public class RequestDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RequestDemo5.doGet()");
		
		/*
		 * 取出Request域中的数据,打印在控制台上
		 */
		String name=(String) request.getAttribute("name");
		int age=(Integer) request.getAttribute("age");
		String addr=(String) request.getAttribute("addr");
		System.out.println(name+":"+age+":"+addr);
		
		
		//处理请求并作出响应
		response.getWriter().write("1000.0$...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
