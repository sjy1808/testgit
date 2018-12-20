package com.beans;
//1.一个非常普通的类
//2.将此类的对象交给spring怎样创建
public class HelloService {

	public HelloService(){
		System.out.println("HelloService()");
	}
	public void sayHello(){
		System.out.println("hello world");
	}
}
