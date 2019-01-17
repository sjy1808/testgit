package com.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tedu.pojo.User;

public interface UserMapper{

	@Select("select * from user")
	public List<User> findAll();
}
