package com.jt.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
/**全局异常处理类*/
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e){
		e.printStackTrace();
		JsonResult r = new JsonResult(e);
		r.setState(0);
		if(e instanceof UnknownAccountException){
			r.setMessage("用户不存在");
		}else if(e instanceof LockedAccountException){
			r.setMessage("用户被禁用");
		}else if(e instanceof IncorrectCredentialsException){
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException){
			r.setMessage("您没有此操作的权限");
		}
		return r;
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
}
