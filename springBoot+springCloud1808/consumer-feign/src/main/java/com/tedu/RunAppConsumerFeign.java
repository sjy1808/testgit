package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RunAppConsumerFeign {

	public static void main(String[] args) {
		SpringApplication.run(RunAppConsumerFeign.class, args);
	}
}
