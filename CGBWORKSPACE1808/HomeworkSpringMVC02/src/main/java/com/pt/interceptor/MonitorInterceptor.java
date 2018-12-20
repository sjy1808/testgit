package com.pt.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 定义监控拦截器(模拟12306中的时间访问控制)
 * @author Administrator
 *
 */
@Component//将对象交给spring管理
public class MonitorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取当前时间
		long time=System.currentTimeMillis();
		//1.1获取当前日历对象
		Calendar c1=Calendar.getInstance();
		c1.set(Calendar.HOUR_OF_DAY, 21);
		c1.set(Calendar.MINUTE,02);
		c1.set(Calendar.SECOND,0);
		long startTime=c1.getTimeInMillis();
		c1.set(Calendar.HOUR_OF_DAY,22);
		long endTime=c1.getTimeInMillis();
		//2.判定时间是否小于允许访问的开始时间
		if(time<startTime){
			System.out.println("每天21:02:00之前不允许访问");
			return false;
		}
		//3.判定时间是否大于允许访问的最后时间
		if(time>endTime){
			System.out.println("每天的22:02:00之后不允许访问");
			return false;
		}
		return true;
	}
}
