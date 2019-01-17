package com.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	//SpringCloud提供的哦第一种方法RestTemplate
	@Autowired
	private RestTemplate restTemplate;//通过这个对象远程访问提供者
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		//调用服务提供者
		//提供者url
		String url="http://localhost:7900/hello/"+name;
		//实现负载均衡
		url="http://provider-hello/hello/"+name;
		return restTemplate.getForObject(url, String.class);
	}
}
