package com.jt.sso.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.service.RedisService;
import com.jt.common.vo.SysResult;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisService redisService;

	
	//把java对象转换成json串,ObjectMapper
	private static final ObjectMapper mapper=new ObjectMapper();
	
	//根据type=1:username,2:phone,3:email
	private static final Map<Integer,String> PARAM_TYPE=new HashMap<Integer,String>();
	//初始化
	static {
		PARAM_TYPE.put(1, "username");
		PARAM_TYPE.put(2, "phone");
		PARAM_TYPE.put(3, "email");
	}
	
	public SysResult check(String param,Integer type) {
		int i = userMapper.check(PARAM_TYPE.get(type), param);
		if(i==0) {
			return SysResult.ok("false");	//数据库没有，可用
		}else {
			return SysResult.build(201, "OK", "true");	//数据库值已经存在，不可用
		}
	}
	
	public boolean register(User user) {
		//密码加密
		String newpassword = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(newpassword);
		
		//判断，如果此用户已经存在，返回不能注册
		int i = userMapper.check(PARAM_TYPE.get(1), user.getUsername());
		if(i>0) {	//用户已经存在
			return false;
		}else {
			userMapper.save(user);
			return true;
		}
	}
	
	public String login(String username, String password) {
		String ticket = null;
		
		//验证用户名密码，不是直接两个查询（SQL注入），习惯：先按用户名查询，然后按密码比较
		User user = userMapper.login(username);
		password = DigestUtils.md5Hex(password);
		
		//判断密码是否和数据库一致
		if(password.equals(user.getPassword())){
			//满足三个特性：动态性、唯一性、混淆性
			ticket = DigestUtils.md5Hex("JT_TICKET_"+System.currentTimeMillis()+username);
			
			//登录成功，把user的json串写入到redis，key=ticket，value=userJson
			try {
				user.setPassword(null);	//密码不应泄漏
				String userJson = mapper.writeValueAsString(user);
				//ticket过期时间，电商系统中习惯7天
				redisService.set(ticket, userJson, 60*60*24*7);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return ticket;
	}
	
	@Override
	public String queryUserByTicket(String ticket) {
		//根据ticket到redis中获取
		String userJson = redisService.get(ticket);
		return userJson;
	}
}

