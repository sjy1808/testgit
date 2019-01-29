package cn.tedu;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")//解决多个请求数据安全性问题
public class HelloAction {

	@Resource
	private DemoService demoService;
	
	public String execute() {
		System.out.println("Hello Action");
		demoService.hello();
		return "success";
	}
}
