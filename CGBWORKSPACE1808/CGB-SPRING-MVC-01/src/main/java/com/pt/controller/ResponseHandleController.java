package com.pt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pt.member.entity.Member;

@Controller
@RequestMapping("/resp/")
public class ResponseHandleController {

	@RequestMapping("doResponse01")
	public void doResponse01(HttpServletResponse response) throws IOException{
		response.getWriter().write("hello spring mvc!");
	}
	@RequestMapping("doResponse02")
	public ModelAndView doResponse02(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("response");
		mv.addObject("msg","hello spring mvc");
		return mv;
	}
	@RequestMapping("doResponse03")
	public String doResponse03(Model model){//一个接口
		model.addAttribute("msg", "heldkfkd kdfjienk");//addObject
		return "response";//viewName请求转发
	}
	//响应方式:
	//spring mvc 中重定向的实现
	//需要在返回的viewName前加上redirect前缀
	@RequestMapping("doResponse05")
	public String doResponse05(){
		return "redirect:doResponse03.do";
	}
	@RequestMapping("doResponse06")
	//将对象内容转换为json格式字符串,然后输出到客户端
	public void doResponse06(HttpServletResponse resp) throws IOException{
		//假设如下map中的数据来自数据库
		Map<String,Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("phone", "23564843");
		Object id=map.get("id");
		Object phone=map.get("phone");
		String jsonStr="{\"id\":\"++\"}";
		resp.getWriter().write(jsonStr);
		
	}
	@RequestMapping("doResponse07")
	@ResponseBody
	public Map<String,Object> doResponse07(){
		Map<String,Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("phone", "23564843");
		return map;
		//底层会启动消息转换器将map对象转换为JSON格式
		//前提:1)添加依赖库2)使用@ResponseBody注解修饰
	}
	@RequestMapping("doResponse08")
	@ResponseBody
	public List<Map<String,Object>> doResponse08(){
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("phone", "23564843");
		list.add(map);
		Map<String,Object> map1=new HashMap<>();
		map1.put("id", 200);
		map1.put("phone", "2356484843");
		list.add(map1);
		return list;
	}
	@RequestMapping("doResponse09")
	@ResponseBody
	public Member doResponse09(){
		Member m=new Member();
		m.setNickname("hfuefu");
		m.setEmail("dfedsf@fdf");
		m.setPassword("1234564");  
		return m;
	}//底层可以将此对象转成json格式字符串
	//底层将对象转换为json串时会调用对象的get方法
	
	
	
	
}
