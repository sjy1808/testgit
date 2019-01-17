package com.tedu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//这个接口相当于把原来服务的提供者项目当成一个Service类
@FeignClient("provider-hello")
public interface EurekaServiceFeign {

	/**
	 * Feign中没有原生的@GetMapping/@PostMapping/@DeleteMapping/@PutMapping,要指定
	 * 需要用method进行
	 */
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name);
}
