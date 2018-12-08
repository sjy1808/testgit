package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request功能三:实现请求转发和域对象
 */
public class RequestDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RequestDemo4.doGet()");
		
		/*
		 * 如果在转发时有数据需要带到目的地,可以将数据存入Request域中,通过转发将数据转到RequestDemo5
		 */
		request.setAttribute("name", "刘德华");
		request.setAttribute("age", 18);
		request.setAttribute("addr", "香港");
		
		/*
		 * 将请求转发到RequestDemo5处理
		 */
		request.getRequestDispatcher("/RequestDemo5").forward(request, response);
		
		//request.getRequestDispatcher("http://www.tmooc.cn").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
