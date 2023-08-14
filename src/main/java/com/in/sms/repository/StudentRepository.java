package com.in.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
