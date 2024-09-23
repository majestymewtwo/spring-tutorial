package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	This is the main program. Once we run this main function,
	then only our server will be running.
	DO NOT CHANGE OR ADD ANYTHING HERE
*/
@SpringBootApplication
public class SpringStudentApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStudentApplication.class, args);
	}
}
