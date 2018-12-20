package com.beans;

public class ConnectionPool {

	public ConnectionPool(){
		System.out.println("ConnectionPool");
	}
	/**
	 * 初始化
	 */
	public void init(){
		System.out.println("init()");
	}
	/**
	 * 销毁
	 */
	
	public void destroy(){
		System.out.println("destroy");
	}
}
