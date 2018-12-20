package com.pt.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/request/")
public class RequestHandleController {

	//==============请求路径映射==============
	@RequestMapping("doRequestPath01")
	@ResponseBody
	public String doRequestPath01(){
		return "<h1>doRequestPath01()</h1>";
	}
	//@ResponseBody注解修饰方法时,假如返回到的是一个字符串,就以普通的字符串进行返回
	
	//实现多个URL映射为同一个资源
	@RequestMapping({"doRequestPath02","djiefndskdf"})
	@ResponseBody
	public String doRequestPath02(){
		return "djiekfj";
	}
	
	//rest风格的URL映射
	@RequestMapping("doRequestPath03/{path}")
	@ResponseBody
	public String doRequestPath03(){
		return "doRequestPath03";
	}
	
	//rest风格的URL参数的获取
	@RequestMapping("doRequestPath04{str}")
	@ResponseBody
	public String doRequestPath04(@PathVariable String str){
		return "doRequestPath04,str="+str;
	}//@PathVariable注解实现参数的获取
	
	//===============请求方式映射======================
	@RequestMapping(value="doRequestPath05",method=RequestMethod.GET)
	@ResponseBody
	public String doRequestPath05(){
		return "doRequestPath05";
	}
	@RequestMapping(value="doRequestPath06",method=RequestMethod.POST)
	@ResponseBody
	public String doRequestPath06(){
		return "doRequestPath06";
	}
	@RequestMapping(value="doRequestPath07",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String doRequestPath07(){
		return "doRequestPath07";
	}
	@PostMapping(value="doRequestPath08")
	@ResponseBody
	public String doRequestPath08(){
		return "doRequestPath08";
	}
	@GetMapping(value="doRequestPath09")
	@ResponseBody
	public String doRequestPath09(){
		return "doRequestPath09";
	}
	
	//============请求参数映射=============
	//1.借助原生Servlet API获取参数
	@RequestMapping("doRequestParam01")
	@ResponseBody
	public String doRequestParam01(HttpServletRequest request){
		String page=request.getParameter("page");
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		return "param's value "+page;
	}
	//2.直接量方式请求参数数据
	@RequestMapping("doRequestParam02")
	@ResponseBody
	public String doRequestParam02(Date date ){
		return "param's date value:"+date;
	}
	@RequestMapping("doRequestParam03")
	@ResponseBody
	public String doRequestParam03(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date ){
		return "param's date value:"+date;
	}
	//使用值对象封装请求参数数据,方法被调用时会构建参数对象,然后基于参数名找对应的set方法,实现值的封装
	@RequestMapping("doRequestParam04")
	@ResponseBody
	public String doRequestParam04(@RequestParam Map<String,Object> map){
		return "param's map value"+map;
	}
	@RequestMapping("doRequestParam05")
	@ResponseBody
	public String doRequestParam05(Integer... ids){
		return "param's value "+Arrays.toString(ids);
	}
	@RequestMapping("doRequestParam06")
	@ResponseBody
	public String doRequestParam06(@RequestHeader String Accept){
		return "param's accept value"+Accept;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
