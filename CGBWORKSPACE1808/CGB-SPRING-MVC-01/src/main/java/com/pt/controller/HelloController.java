package com.pt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 此类如何作为spring MVC中的后端处理器
 * 借助@Controller注解修饰
 */
@Controller//==<bean id="helloController" class=""/>
@RequestMapping("/")
public class HelloController {

	@RequestMapping("doSayHello")
	public ModelAndView doSayHello(){
		String msg="hello spring mvc";
		//spring mvc 模块提供的一个用于封装值的对象
		ModelAndView mv=new ModelAndView();
		//页面上要呈现的数据可以通过addObject方法进行封装
		mv.addObject("msg",msg);//底层存放到map
		//设置响应页面
		mv.setViewName("hello");
		return mv;//返回值会交给DispatcherServlet
		//DispatcherServlet调用视图解析器对view进行解析
		//最后将请求转发到对应的页面(/WEB-INF/pages/)
		
	}
}
