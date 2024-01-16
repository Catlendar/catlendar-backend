package com.catlendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatlendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatlendarApplication.class, args);
		System.out.println("auto reload");
	}

}
