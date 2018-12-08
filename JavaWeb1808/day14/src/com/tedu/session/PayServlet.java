package com.tedu.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取session对象
		HttpSession session=request.getSession();
		//2.从session中获取商品信息
		String prod=(String) session.getAttribute("prod");
		//3.模拟支付并作出回应
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("成功为["+prod+"]支付了1300.0元...");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
