package com.test;

import org.junit.Test;

import com.beans.Configuration;

public class TestConfiguration01 extends TestBase {

	@Test
	public void testConfiguration01(){
		Configuration cfg=ctx.getBean("config",Configuration.class);
		System.out.println(cfg.getList());
		System.out.println(cfg.getMap());
		System.out.println(cfg.getProperties());

	}
}
