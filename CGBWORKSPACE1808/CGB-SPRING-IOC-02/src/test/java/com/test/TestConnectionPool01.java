package com.test;

import org.junit.Test;

import com.beans.ConnectionPool;

public class TestConnectionPool01 extends TestBase {

	@Test
	public void testConnectionPool01(){
		ConnectionPool cp01 = ctx.getBean("connPool01",ConnectionPool.class);
		System.out.println(cp01);
	}
	@Test
	public void testConnectionPool02(){
		ConnectionPool cp02 = ctx.getBean("connPool02",ConnectionPool.class);
		System.out.println(cp02);
	}
	@Test
	public void testConnectionPool03(){
		ConnectionPool cp03 = ctx.getBean("c3p0",ConnectionPool.class);
		System.out.println(cp03);
	}

}
