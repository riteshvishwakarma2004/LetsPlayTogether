package com.Ritesh.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class LetsPlayTogetherApplication {

	public static void main(String[] args) {

		SpringApplication.run(LetsPlayTogetherApplication.class, args);
		System.out.println("Hello");
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String date = dateTime.format(formatter);
		System.out.println(date);
	}

}
