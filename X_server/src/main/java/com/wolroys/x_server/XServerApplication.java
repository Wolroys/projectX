package com.wolroys.x_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class XServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XServerApplication.class, args);
	}

}
