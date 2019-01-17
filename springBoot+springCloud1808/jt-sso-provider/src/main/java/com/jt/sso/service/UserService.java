package com.jt.sso.service;

import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;

public interface UserService {

	public SysResult check(String param,Integer type);
	public boolean register(User user);
	public String login(String userName, String passwd);
	public String queryUserByTicket(String ticket);

}
