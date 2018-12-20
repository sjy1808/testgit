package com.pt.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
@Aspect
@Service
public class TimeAspect {

	@Pointcut("bean(orderService)")
	public void pointCut(){	}
	
	/**增强功能:前置通知(业务方法执行之前执行)*/
	@Before("pointCut()")
	public void begin(){
		System.out.println("start:"+System.nanoTime());
	}
	
	/**增强功能:最终通知(业务方法执行最后执行,无论业务方法是否执行成功,此功能都要执行)*/
	@After("pointCut()")
	public void end(){
		System.out.println("end"+System.nanoTime());
	}
}
