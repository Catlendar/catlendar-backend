package com.catlendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class CatlendarApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CatlendarApplication.class, args);
		System.out.println("comfile success");
	}
}
