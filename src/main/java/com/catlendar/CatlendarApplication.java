package com.catlendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class CatlendarApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CatlendarApplication.class, args);
		String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
				.format(LocalDateTime.now());
		System.out.println("successfully compiled the code..,,,,. "+dateTime);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
