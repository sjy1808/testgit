package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试基类(测试的共性代码)
 */
public class TestBase {

//	protected ClassPathXmlApplicationContext ctx;
//	protected BeanFactory ctx;
	protected ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){//初始化@Before
		String cfg="spring-configs.xml";
		ctx=new ClassPathXmlApplicationContext(cfg);
	}
	@After
	public void close(){//释放资源@Test
		ctx.close();
	}
}
