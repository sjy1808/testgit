package com.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestBase {

	protected SqlSessionFactory factory;
	@Before
	public void init() throws IOException {
		factory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-configs.xml"));
	}
	@Test
	public void testSqlSessionFactory(){
		System.out.println(factory);
	}
}
