package com.pt.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 借助拦截器监控控制层方法
 * @author Administrator
 * @Component 注解修饰的类,对于spring容器会看成是一个特殊的bean对象,默认这个bean的名字为类名首字母小写,也可自己定义
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
	//服务器启动时创建拦截器对象,只创建一次
	public TimeInterceptor(){
		System.out.println("TimeInterceptor");//查看什么时候加载
	}
	
	/**控制层(后端控制器)方法执行之前*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Time.preHandle");
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;//请求会被拦截,不在继续传递
	}
	/**后端控制器方法执行结束*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Time.postHandle");
		long endTime=System.currentTimeMillis();
		long time=endTime-(long)request.getAttribute("startTime");
		
		//输出handler指向的具体类的类型
		System.out.println("handler="+handler);
		System.out.println("handler.class="+handler.getClass().getName());
		HandlerMethod hMethod=(HandlerMethod)handler;
		//获取handler指向的bean的具体类型
		String beanTypeName=hMethod.getBeanType().getName();
		System.out.println("beanTypeName="+beanTypeName);
		//获取bean对象中被拦截的方法信息
		String methodName=hMethod.getMethod().getName();
		System.out.println("methodName="+methodName);
		System.out.println(beanTypeName+"控制层的"+methodName+"方法执行的时长为:"+time);
		/*Class<? extends Object> c = handler.getClass();
		Method[] method = c.getDeclaredMethods();
		for(Method m:method){
			System.out.println(m);
		}
		System.out.println(method[0]);*/

	}
	/**视图解析完成*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Time.afterCompletion");

	}

}
