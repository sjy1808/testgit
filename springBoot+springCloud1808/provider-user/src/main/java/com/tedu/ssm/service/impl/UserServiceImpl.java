package com.tedu.ssm.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tedu.ssm.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.ssm.pojo.User;
import com.tedu.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.selectList(null);
	}

	@Override
	public User get(Integer id) {
		EntityWrapper<User> wrapper=new EntityWrapper<User>();
		//id是数据库字段,占位符{0} {1}
		wrapper.where("id={0}", id);
		List<User> userList = userMapper.selectList(wrapper);
		if(userList!=null) {
			return userList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
		
	}

}
