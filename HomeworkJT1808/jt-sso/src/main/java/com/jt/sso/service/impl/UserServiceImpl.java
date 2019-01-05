package com.jt.sso.service.impl;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.User;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.service.UserService;

import redis.clients.jedis.JedisCluster;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Autowired
	private JedisCluster jedisCluster;

	/**
	 * 1.通过type类型确定用户校验的字段
	 * 2.根据用户传值和字段查询数据库
	 */
	@Override
	public Boolean findCheckUser(String param, Integer type) {
		String column=null;
		switch (type) {
		case 1:
			column="username";
			break;
		case 2:
			column="phone";
			break;
		case 3:
			column="email";
			break;
		}
		int count=userMapper.findCheckUser(param,column);
		//true用户已经存在,false用户不存在
		return count==0?false:true;
	}

	@Override
	public void saveUser(User user) {
		user.setEmail(user.getPhone());
		user.setCreated(new Date());
		user.setUpdated(user.getCreated());
		userMapper.insert(user);
	}

	
	/**
	 * 1.根据用户名和密码查询用户是否存在
	 * 		如果用户不存在,返回null
	 * 2.如果用户存在,则生成加密秘钥
	 * 		md5("JT_TICKET"+System.currentTime+username)
	 * 3.将user对象转化为userJSON数据
	 * 4.将秘钥:userJSON保存到redis中
	 * 5.返回token
	 */
	@Override
	public String findUserByUP(User user) {
		//根据用户名和密码查询信息
		User userDB=userMapper.findUserByUP(user);
		if(userDB==null){
			//表示用户输入的用户名或者密码错误
			return null;
		}
		//userDB 不为空,表示有数据,生成秘钥
		String token=DigestUtils.md5Hex("JT_TICKET")+System.currentTimeMillis()+userDB.getUsername();
		try {
			String userJSON=objectMapper.writeValueAsString(userDB);
			jedisCluster.setex(token, 7*24*3600, userJSON);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return token;
	}
}
