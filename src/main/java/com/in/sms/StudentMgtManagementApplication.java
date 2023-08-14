 package com.in.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentMgtManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgtManagementApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;

	
	public void run(String... args) throws Exception{
		
	}
}
