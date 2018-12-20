package com.pt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通过@ControllerAdvice注解修饰类,
 * 设置此类为全局异常处理类
 * @author Administrator
 *
 */
@ControllerAdvice
public class ClobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleRuntimeException(RuntimeException e){
		System.err.println("ClobalExceptionHandler.doHandleRuntimeException");
		return e.getMessage();
	}
}
