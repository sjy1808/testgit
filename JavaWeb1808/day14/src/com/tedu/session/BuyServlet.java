package com.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 负责将商品加入购物车
 */
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取要添加到购物车的商品信息
		String prod=request.getParameter("prod");
		/*
		 *如果在server.xml中通过URIEncoding="utf-8"
		 *处理过GET提交的乱码问题,此处不需要重复处理
		 *反之,则需要手动编解码处理GET提交的参数乱码问题
		 *
		 * prod=new String(prod.getBytes(iso8859-1));
		 */
		
		//2.获取session对象(作为购物车使用)
		HttpSession session=request.getSession();
		
		//3.将商品保存到session域中
		session.setAttribute("prod",prod);
		//4.响应浏览器
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("成功将["+prod+"]加入了购物车");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
