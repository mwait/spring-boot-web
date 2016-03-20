package com.wait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.wait"})
@EnableAutoConfiguration
public class SpringBootWebApplication {

	public static void main(String[] args) {
	SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
