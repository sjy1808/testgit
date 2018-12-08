package com.tedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterDemo1 implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*在Filter实例创建之后立即执行,进行初始化的操作
		 * Filter实例创建:服务器启动Web;应用被加载之后,将会创建出所有的Filter实例*/
		System.out.println("Filter实例创建了!...");
	}
	
	/*对过滤器拦截到的请求进行相关处理的核心方法
	 *在这个方法中可以决定请求是否能狗接着往后执行*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo1...");
		//0.处理请求参数乱码(POST)
		request.setCharacterEncoding("utf-8");
		//0.处理响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取暗号
		String code=request.getParameter("code");
		
		//2.判断暗号是否正确
		if("天王盖地虎".equals(code)){
			//>>如果暗号正确,则放行请求接着往后执行
			
			//放行过滤器
			chain.doFilter(request, response);
		}else{
			//>>如果暗号不正确,则提示用户暗号输入错误
			response.getWriter().write("<h1 style='color:blue;'>暗号输入错误!</h1>");
			//>>定时刷新,3秒之后跳转到暗号输入界面
			HttpServletResponse res=(HttpServletResponse) response;
			HttpServletRequest req=(HttpServletRequest) request;
			
			//res.setHeader("Refresh", "3;url=/day16/code.html");
			res.setHeader("Refresh", "3;url="+req.getContextPath()+"/code.html");
			
		}
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("Filter实例销毁了!...");
		
	}
}
