package com.dessert.exception.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;

/**
 * 全局异常处理类
 * @author Administrator
 */
@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e){
		e.printStackTrace();
		JsonResult r = new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException){
			r.setMessage("用户名不存在");
		}else if(e instanceof IncorrectCredentialsException){
			r.setMessage("密码不正确");
		}else {
			r.setMessage(e.getMessage());
		}
		return r;
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
