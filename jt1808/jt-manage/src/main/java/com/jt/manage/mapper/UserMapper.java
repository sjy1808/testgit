package com.jt.manage.mapper;

import java.util.List;

import com.jt.manage.pojo.User;

public interface UserMapper {

	//查询用户表中的数据
	List<User> findAll();
}
