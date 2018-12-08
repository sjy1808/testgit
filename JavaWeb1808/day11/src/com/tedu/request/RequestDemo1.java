package com.tedu.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request功能一:获取客户机的基本信息和获取请求头信息
 */
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.getRequestURL
		String url=request.getRequestURL().toString();
		System.out.println("url"+url);
		
		//2.getRemoteAddr
		String ip=request.getRemoteAddr();
		System.out.println("ip"+ip);
		
		//3.getContextPath
		String path=request.getContextPath();
		System.out.println("contextPath:"+path);
		
		//4.getHeader
		String host=request.getHeader("host");
		System.out.println("访问的主机为:"+host);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
