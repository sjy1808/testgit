package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 测试基类(测试的共性代码)
 * @author Administrator
 *
 */
public class TestBase {

	protected ClassPathXmlApplicationContext cpx;
	@Before
	public void init(){
		cpx = new ClassPathXmlApplicationContext("spring-configs.xml");
	}
	@After
	public void close(){
		cpx.close();
	}
}
