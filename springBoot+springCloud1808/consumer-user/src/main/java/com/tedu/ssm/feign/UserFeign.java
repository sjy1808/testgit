package com.tedu.ssm.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.ssm.pojo.User;

@FeignClient("provider-user")		//指向访问的提供者
public interface UserFeign {

	@RequestMapping("/user/findAll")
	public List<User> findAll();
	
	@RequestMapping("/user/get/{id}")
	public User get(@PathVariable("id") Integer id);
	
	@RequestMapping("/user/insert/{name}/{birthday}/{address}/{id}")
	public String insert(User user);
}
