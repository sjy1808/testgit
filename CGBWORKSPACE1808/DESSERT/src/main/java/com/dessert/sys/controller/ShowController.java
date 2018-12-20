package com.dessert.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ShowController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

	@RequestMapping("doEmployeeLoginUI")
	public String doEmployeeLoginUI() {
		return "employeeLogin";
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	@RequestMapping("index")
	public String Index() {
		return "index";
	}

	@RequestMapping("start")
	public String start() {
		return "Lv/start";
	}

	@RequestMapping("login")
	public String doLoginUI() {
		return "Lv/login";
	}

	@RequestMapping("dessert")
	public String dessert() {
		return "Lv/dessert";
	}

	@RequestMapping("bread")
	public String bread() {
		return "Lv/bread";
	}

	@RequestMapping("cake")
	public String cake() {
		return "Lv/cake";
	}

	@RequestMapping("coffee")
	public String coffee() {
		return "Lv/coffee";
	}

	@RequestMapping("ice")
	public String ice() {
		return "Lv/ice_cream";
	}

	@RequestMapping("register")
	public String register() {
		return "Lv/register";
	}

	@RequestMapping("member")
	public String member() {
		return "Lv/member";
	}

	@RequestMapping("cart")
	public String cart() {
		return "Lv/cart";
	}

	@RequestMapping("cart_checkout")
	public String cart_checkout() {
		return "Lv/cart_checkout";
	}

}
