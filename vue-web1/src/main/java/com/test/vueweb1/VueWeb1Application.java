package com.test.vueweb1;

import com.test.controller.RequestParam;
import com.test.controller.plugin.Myplugn;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@ComponentScan("com.test")
@MapperScan("com.test")
@EnablePluginRegistries({ Myplugn.class })
public class VueWeb1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(VueWeb1Application.class, args);


	}

}
