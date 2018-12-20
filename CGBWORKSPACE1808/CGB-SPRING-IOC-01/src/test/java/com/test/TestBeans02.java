package com.test;

import org.junit.Test;

import com.beans.ConnectionPool;
import com.beans.HelloService;
import com.beans.ObjectFactory;
import com.beans.ObjectFactoryBean;

public class TestBeans02 extends TestBase {

	@Test
	public void testHelloService(){
		//1.获取HelloService对象
		HelloService hService=ctx.getBean("helloService",HelloService.class);
		//2.应用HelloService对象
		hService.sayHello();
	}
	/*
	 * 1.ObjectFactoryBean类型的对象是否创建了?
	 * 2.如何验证ObjectFactoryBean对象是否创建了?
	 * 3.ObjectFactory类型的对象如何创建的
	 */
	@Test
	public void testObjectFactor(){
		//1.获取bean对象
		ObjectFactory of1 = 
				ctx.getBean("objectFactory",ObjectFactory.class);
		System.out.println(of1);
		ObjectFactory of2 = 
				ctx.getBean("objectFactory",ObjectFactory.class);
		System.out.println(of2);
		//2.输出bean对象
		System.out.println(of1==of2);
	}
	/*
	 * 
	 */
	@Test
	public void testObjectFactorBean(){
		//1.获取bean对象
		ObjectFactoryBean ofBean = 
				ctx.getBean("&objectFactory",ObjectFactoryBean.class);
		//2.输出bean对象
		System.out.println(ofBean);
	}
	
	@Test
	public void testConnectionPool(){
		ConnectionPool cp1=ctx.getBean("cPool", ConnectionPool.class);
		ConnectionPool cp2=ctx.getBean("cPool", ConnectionPool.class);
		System.out.println(cp1==cp2);
	}
}
