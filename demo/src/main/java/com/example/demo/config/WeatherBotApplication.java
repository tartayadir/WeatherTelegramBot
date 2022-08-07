package com.example.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class WeatherBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherBotApplication.class, args);
	}

}
