package com.test.vueweb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.test")
public class VueWeb1Application {

	public static void main(String[] args) {
		SpringApplication.run(VueWeb1Application.class, args);
	}

}
