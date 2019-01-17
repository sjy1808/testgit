package com.tedu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-hello")		//调用对应服务提供者
public interface HelloFeign {

	//代理谁?提供者controller代理 , 要求统一返回值,返回类型,函数名,参数,参数类型
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name);
}
