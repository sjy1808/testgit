package com.jt.manage.test;

import java.util.Map;

import org.junit.Test;

import com.jt.manage.pojo.User;

import redis.clients.jedis.Jedis;

public class TestRedis {

	@Test
	public void testString(){
		Jedis jedis = new Jedis("192.168.80.135",6379);
		jedis.set("1812", "基地是覅恩登记费ID及覅额");
		System.out.println("输出:"+jedis.get("1812"));
		jedis.expire("1812", 20);
		//设定数据同时设定超市时间
		jedis.setex("1812", 30, "大家开房间诶是否是佛山市");
	}
	@Test
	public void testHash(){
		User user = new User();
		user.setId(1231);
		user.setAge(25);
		user.setName("我的最爱");
		user.setSex("nv");
		Jedis jedis = new Jedis("192.168.80.135",6379);
		jedis.hset("user", "id", user.getId()+"");
		jedis.hset("user", "age", user.getAge()+"");
		jedis.hset("user", "name", user.getName());
		jedis.hset("user", "sex", user.getSex());
		Map<String,String> map=jedis.hgetAll("user");
		System.out.println(map);
		
	}
}
