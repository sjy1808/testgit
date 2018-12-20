package com.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBase {
	protected SqlSessionFactory factory;
	/**
	 * 此方法会在@Test注解修饰的方法之前执行
	 * @throws IOException 
	 */
	@Before
	public void init() throws IOException{
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs.xml"));
	}
	@Test
	public void testSqlSessionFactory(){
		//测试factory 是否不等于null
		Assert.assertNotEquals(null,factory);//断言测试
		//假如factory不等于null则输出factory的值
		System.out.println(factory);
	}
	
}
