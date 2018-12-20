package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 此控制器定义 相关页面映射
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class PageController {

	/**此方法返回首页页面*/
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";
	}
	/**通过此方法返回分页页面*/
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
}
