package com.jankenfighteralpha.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.jankenfighteralpha")
@SpringBootApplication
public class JankenFighterAlphaRpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JankenFighterAlphaRpsApplication.class, args);
	}

}
