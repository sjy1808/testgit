package com.tedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String nickname = request.getParameter("nickname");
		String desc = request.getParameter("desc");
		String url = request.getRequestURL().toString();
		
		request.setAttribute("username", username);
		request.setAttribute("password", password1);
		request.setAttribute("nickname", nickname);
		request.setAttribute("desc", desc);
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		//定时刷新
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("恭喜您注册成功,3秒之后将会跳转到首页!");
		response.setHeader("Refresh", "3;url="+request.getContextPath()+"/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
