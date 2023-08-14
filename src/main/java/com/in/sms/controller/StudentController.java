package com.in.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.in.sms.entity.Student;
import com.in.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list students and return mode and view
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "student";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "createStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model mode) {
		
		//get student by id from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	
	//handler method to handle delete student request 
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
