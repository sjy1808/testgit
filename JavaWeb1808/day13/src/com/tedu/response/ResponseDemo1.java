package com.tedu.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Response功能一:向客户端发送数据
 */
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.getOutputStream()
		//通知浏览器使用utf-8接收服务器发送过来的数据
		/*response.setContentType("text/html;charset=utf-8");
		
		ServletOutputStream out = response.getOutputStream();
		//out.write("Hello CGB1808".getBytes("utf-8"));
		out.write("你好  CGB1808".getBytes("utf-8"));*/
		
		//2.getWriter()
		//底层还是字符转成字节
		//通知服务器使用utf-8发送数据
		
		//再通知浏览器也使用utf-8接收数据
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.write("你好  CGB1808");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
