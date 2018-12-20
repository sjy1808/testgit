package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestConnectionPool02 extends TestBase {

	@Test
	public void testC3p0() throws Exception{
		//1.获取连接池对象
		ComboPooledDataSource ds = ctx.getBean("c3p0",ComboPooledDataSource.class);
		System.out.println(ds);
		//2.获取连接对象
		Connection conn=ds.getConnection();
		System.out.println("conn="+conn);
	}
	@Test
	public void testDruid() throws Exception{
		//1.获取连接池对象
		DruidDataSource dds = ctx.getBean("druid",DruidDataSource.class);
		System.out.println(dds);
		//2.获取连接对象
		Connection conn=dds.getConnection();
		System.out.println("conn="+conn);
	}
}
