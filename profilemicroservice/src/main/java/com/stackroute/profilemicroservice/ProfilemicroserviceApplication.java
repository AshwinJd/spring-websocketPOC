package com.stackroute.profilemicroservice;

import com.github.mthizo247.cloud.netflix.zuul.web.socket.EnableZuulWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ProfilemicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilemicroserviceApplication.class, args);
	}

}
