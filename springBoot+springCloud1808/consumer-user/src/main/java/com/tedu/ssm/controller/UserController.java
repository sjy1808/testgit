package com.tedu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.ssm.feign.UserFeign;
import com.tedu.ssm.pojo.User;

@RestController
public class UserController {

	@Autowired
	private UserFeign userFeign;
	
	@RequestMapping("/user/findAll")
	public List<User> findAll(){
		return userFeign.findAll();
	}
	
	@RequestMapping("/user/get/{id}")
	public User get(@PathVariable("id") Integer id) {
		return userFeign.get(id);
	}
	
	@RequestMapping("/user/insert/{name}/{birthday}/{address}/{id}")
	public String insert(User user) {
		return userFeign.insert(user);
	}
}