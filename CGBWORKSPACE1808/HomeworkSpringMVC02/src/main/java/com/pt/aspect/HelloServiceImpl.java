package com.pt.aspect;

public class HelloServiceImpl implements HelloSerivce {

	@Override
	public void sayHello(String msg) {
		//假设这条语句是我们系统中的核心业务
		System.out.println(msg);
	}

}
