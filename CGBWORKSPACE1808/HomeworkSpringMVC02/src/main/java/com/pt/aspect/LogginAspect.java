package com.pt.aspect;

public class LogginAspect {

	public void beforeMethod(){
		System.out.println("method start");
	}
	public void afterMethod(){
		System.out.println("method end");
	}
}
