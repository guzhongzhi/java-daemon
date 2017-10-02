package com.example.demo;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {
	private static final Logger logger = org.apache.logging.log4j.core.LoggerContext.getContext().getLogger(DemoApplication.class.toString());

	public static void main(String[] args) {
		logger.error("FFFFFFFFFFF");
		SpringApplication.run(DemoApplication.class, args);
	}
}
