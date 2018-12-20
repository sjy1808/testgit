package com.pt.aspect;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP01 {

	private ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@Test
	public void testSayHello(){
		HelloSerivce helloService = ctx.getBean("helloService",HelloSerivce.class);
		helloService.sayHello("cjksfjie");
	}
	@After
	public void destory(){
		ctx.close();
	}
}
