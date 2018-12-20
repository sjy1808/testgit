package com.pt.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.vo.SqlOrderCommand;

@Controller
@RequestMapping("/req/")
public class RequestHadleController {
	//==============请求路径映射=======================
	@RequestMapping("doRequestPath01")
	@ResponseBody//返回一个字符串,以普通串的形式返回到页面
	public String doRequestPath01(){
		
		return "doRequestPath01";
	}
	//@ResponseBody注解修饰方法时,假如返回的是一个字符串,就以普通串的形式进行返回
	
	//如何实现多个URL映射为同一个资源
	@RequestMapping({"doRequestPath001","doRequestPath02"})
	@ResponseBody
	public String doRequestPath02(){
		return "doRequestPath02";
	}
	
	//rest风格的URL映射
	@RequestMapping("doRequestPath03/{path}")
	@ResponseBody
	public String doRequestPath03(){
		return "doRequestPath03";
	}
	//rest风格的URL参数的获取(借助@PathVariable注解实现)
	@RequestMapping("doRequestDelete/{id}")
	@ResponseBody
	public String doRequestPath04(@PathVariable Integer id){
		return "doRequestPath04,id="+id;
	}
	
	//==============请求方式映射==================
	//指定方法只处理Get和POST请求
	@RequestMapping(value="doRequestMethod01",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String doRequestMethod01(){
		return "doRequestMethod01";
	}
	@RequestMapping("doRequestMethod02")
	@ResponseBody
	public String doRequestMethod02(){
		return "doRequestMethod02";
	}
	//执行方法只支持Get请求
	@GetMapping(value="doRequestMethod002")
	@ResponseBody
	public String doRequestMethod002(){
		return "doRequestMethod02";
	}
	//执行方法只支持POST请求
	@PostMapping(value="doRequestMethod0002")
	@ResponseBody
	public String doRequestMethod0002(){
		return "doRequestMethod02";
	}
	//===========请求参数映射======================
	//1.借助原生servlet API获取数据
	@GetMapping("doRequestParam01")
	@ResponseBody
	public String doRequestParam01(HttpServletRequest request){
		String page=request.getParameter("page");
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		return "param's value "+page;
	}
	//2直接量方式获取请求参数数据
	/**
	 * @RequestMapping 用于修饰方法参数
	 * 1)value属性用于指定要获取请求中那个参数的值
	 * 2)required属性表示请求是否允许没有这个参数,默认为true
	 * @param name
	 * @return
	 */
	@GetMapping("doRequestParam02")
	@ResponseBody
	public String doRequestParam02(String name){
		return "param's value "+ name;
	}
	@ResponseBody
	@RequestMapping("doRequestParam05")
	public String doRequestParam05(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date){
		return "param's begindate value "+ date;
	}
	//使用值对象封装请求参数数据,方法被调用时会构建参数对象,然后基于参数名找对应的set方法,实现值的封装
	@ResponseBody
	@RequestMapping("doRequestParam06")
	public String doRequestParam06(SqlOrderCommand comm){
		return "param's comm value "+ comm;
	}
	//当使用map封装请求数据时,必须使用@RequestParam注解修饰,然后会以key/value的形式存放到map中
	@ResponseBody
	@RequestMapping("doRequestParam07")
	public String doRequestParam07(@RequestParam Map<String,Object> map){
		return "param's map value "+ map;
	}//通过
	@ResponseBody
	@RequestMapping("doRequestParam08")
	public String doRequestParam08(@RequestHeader String Accept){
		return "param's accept value "+ Accept;
	}
	@ResponseBody
	@RequestMapping("doRequestParam09")
	public String doRequestParam09(@RequestHeader("Accept-Encoding") String AcceptEncoding){
		return "param's accept-encoding value "+ AcceptEncoding;
	}
	@ResponseBody
	@RequestMapping("doRequestParam10")
	public String doRequestParam10(@CookieValue("JSESSIONID") String Cookie){
		return "param's Cookie value "+ Cookie;
	}
	@ResponseBody
	@RequestMapping("doRequestParam11")
	public String doRequestParam11(HttpEntity<String> entity){
		return "param's entity value "+ entity;
	}
}
