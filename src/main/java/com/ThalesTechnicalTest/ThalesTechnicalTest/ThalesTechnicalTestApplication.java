package com.ThalesTechnicalTest.ThalesTechnicalTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class ThalesTechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThalesTechnicalTestApplication.class, args);
	}

}
