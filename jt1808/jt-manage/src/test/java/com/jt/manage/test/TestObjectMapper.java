package com.jt.manage.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.pojo.User;

public class TestObjectMapper {

	@Test
	public void toJSON() throws IOException{
		User user = new User();
		user.setId(123);
		user.setName("json测试");
		user.setAge(18);
		user.setSex("男");
		//将对象转化为json,依赖对象中的get方法
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(user);
		System.out.println(result);
		
		//将json数据转化为对象 依赖对象中的set方法
		User objUser = mapper.readValue(result,User.class);
		System.out.println("获取对象:"+objUser);
		
	}
	@Test
	public void toJSON1() throws IOException{
		User user = new User();
		user.setId(123);
		user.setName("json测试");
		user.setAge(18);
		user.setSex("男");
		
		User user1 = new User();
		user1.setId(124);
		user1.setName("json测试1");
		user1.setAge(19);
		user1.setSex("男");
		List<User> userList=new ArrayList<>();
		userList.add(user);
		userList.add(user1);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(userList);
		System.out.println(result);
		
		//将ListJson转化为List对象  调用集合的toString方法
		List<User> uList = mapper.readValue(result, userList.getClass());
		System.out.println(uList);
		
		User[] users = mapper.readValue(result, User[].class);
		//数组转化成list集合  调用数组的toString方法
		List<User> arrayList=Arrays.asList(users);
		System.out.println(arrayList);
		
		
	}
	
}
