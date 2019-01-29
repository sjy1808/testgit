package cn.tedu;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.service.UserService;

@Controller
@Scope("prototype")
public class LoginAction implements SessionAware {

	private String name;
	private String password;
	private Result result;
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private Map<String,Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Autowired
	private UserService userService;
	
	public String login() {
		Result result=userService.login(name, password);
		this.result=result;
		//成功情况的处理
		if(result.getStatus()==0) {
			UserPwd user=(UserPwd) result.getData();
			session.put("loginUser", user);
		}else {
			UserPwd user=(UserPwd) result.getData();
			return "error";
		}
		return "success";
	}
	
}
