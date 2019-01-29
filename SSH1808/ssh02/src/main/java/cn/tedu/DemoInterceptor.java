package cn.tedu;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DemoInterceptor implements Interceptor {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation in) throws Exception {
		System.out.println("开始拦截");
		
		in.invoke();//放行,调用Action
		
		System.out.println("结束拦截");
		return null;
	}

}
