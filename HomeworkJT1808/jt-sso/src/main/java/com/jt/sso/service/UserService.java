package com.jt.sso.service;

import com.jt.common.po.User;

public interface UserService {

	Boolean findCheckUser(String param, Integer type);

	void saveUser(User user);

	String findUserByUP(User user);

}
