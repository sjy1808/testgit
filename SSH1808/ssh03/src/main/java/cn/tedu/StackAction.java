package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
@Scope("prototype")
public class StackAction {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String test() {
		ActionContext ctx=ActionContext.getContext();
		ValueStack stack=ctx.getValueStack();
		message="demo";
		Person p=new Person(1,"Jerry","Hello Jerry!");
		stack.push(p);
		ctx.getSession().put("loginName", "Tom");
		return "success";
	}
}
