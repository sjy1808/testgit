package com.jt.sso.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;


@FeignClient("jt-sso-provider")
public interface UserFeign {
	@RequestMapping("/user/check/{param}/{type}")
	public SysResult check(@PathVariable("param") String param,@PathVariable("type") Integer type);
	
	@RequestMapping("/user/register")
	public SysResult register(User user);	//改造服务提供者，@RequestBody，使用json方式接参
	//Feign底层选择REST+json方式。
	
	@RequestMapping("/user/login")
	public SysResult login(@RequestParam("u") String username,@RequestParam("p") String password);
	
	@RequestMapping("/user/query/{ticket}")
	public SysResult queryByTicket(@PathVariable("ticket") String ticket);
}
