package com.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 
 * ServletContext对象的生命周期监听器
 * 当sc对象创建时会通知监听器调用contextInitialized
 * 当sc对象销毁时也会通知监听器调用contextDestroyed
 * 
 */
public class MyServletContextListener implements ServletContextListener{
	
	/*在服务器启动Web应用被加载后创建sc对象*/
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("我轻轻的来了....");
	}
	/*在服务器关闭或者Web应用被移除容器销毁sc对象*/
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("我轻轻的又走了....");
	}
	
}
