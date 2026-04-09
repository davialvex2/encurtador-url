package com.daviaugusto.conversor_url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class ConversorUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorUrlApplication.class, args);
	}

}
