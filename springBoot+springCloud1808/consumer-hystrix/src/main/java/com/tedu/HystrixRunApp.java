package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients		//开启feign
//@EnableCircuitBreaker	//开启hystrix
public class HystrixRunApp {

	public static void main(String[] args) {
		SpringApplication.run(HystrixRunApp.class, args);
	}
}
