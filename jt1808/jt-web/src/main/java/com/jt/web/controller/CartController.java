package com.jt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.Cart;
import com.jt.common.po.User;
import com.jt.common.vo.SysResult;
import com.jt.web.service.CartService;
import com.jt.web.thread.UserThreadLocal;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	//跳转到购物车页面
	@RequestMapping("/show")
	public String findCartByUserId(Model model,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("JT_USER");
		Long userId=user.getId();//暂时写死
		List<Cart> cartList=cartService.findCartByUserId(userId);
		model.addAttribute("cartList",cartList);
		return "cart";
	}
	
	//实现商品数量的修改
	@RequestMapping("/update/num/{itemId}/{num}")
	@ResponseBody
	public SysResult updateNumber(@PathVariable Long itemId,@PathVariable Integer num){
		try {
			Long userId=UserThreadLocal.get().getId();
			cartService.updateNumber(userId,itemId,num);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "商品修改失败!");
	}
	
	//购物车的删除,重定向跳转到购物车列表页面
	/**
	 * 转发:
	 * 		参数:可以携带参数
	 * 		请求路径地址:转化不变
	 * 		请求次数:1
	 * 		建议使用:绝对路径
	 * 重定向:
	 * 		参数:不能携带参数
	 * 		请求次数:多次 
	 *  	请求路径地址:会发生变化
	 */
	@RequestMapping("/delete/{itemId}")
	public String deleteCart(@PathVariable Long itemId){
		Long userId=UserThreadLocal.get().getId();
		cartService.deleteCart(userId,itemId);
		return "redirect:/cart/show.html";//重定向到列表页面
	}
	@RequestMapping("/add/{itemId}")
	public String saveCart(@PathVariable Long itemId,Cart cart){
		Long userId=UserThreadLocal.get().getId();
		cart.setUserId(userId);
		cart.setItemId(itemId);
		cartService.saveCart(cart);
		//如果操作一切正常,则重定向到购物车列表页面
		return "redirect:/cart/show.html";
	}
}