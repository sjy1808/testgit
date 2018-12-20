package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pt.HelloService;

public class TestBeans01 {

	public static void main(String[] args) {
		/*
		 * 1.初始化spring框架对象
		 * 1.1读取xml文件中的配置信心(xml解析)
		 * 1.2存储配置信息
		 */
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
		/*
		 * 2.获取bean对象
		 * 2.1何时创建de?(要看配置,是否配置了延迟加载)
		 * 2.2如何创建的:(通过反射技术:Class.forName("beans.HelloService"))
		 * 2.3此对象从哪里获取?(IOC容器-->底层map)
		 */
		HelloService hService=ctx.getBean("helloService",HelloService.class);
		/*
		 * 3.应用bean对象
		 */
		hService.sayHello();
		//4.释放资源
		ctx.close();
	}
}
