package cn.tedu;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

//import com.opensymphony.xwork2.ActionContext;

public class Login2Action implements SessionAware {

	private User user;
	private String message;
	private Map<String,Object> session;
	public Login2Action() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String execute() {
		//工厂方法获取session 对象
//		ActionContext ctx=ActionContext.getContext();
//		Map<String,Object> sesssion =ctx.getSession();
		
		//注入的方法
		if(user.getName().equals("Tom")&&user.getPwd().equals("123")) {
			session.put("loginName", "Tom");
			return "success";
		}
		message="用户名或密码错误,请重新登录";
		return "error";
	}
}
