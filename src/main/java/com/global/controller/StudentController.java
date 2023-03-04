package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.global.entity.Student;
import com.global.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> std = studentService.getAllStudents();
		model.addAttribute("students",std );
		return "students";
	}
	
	
	@GetMapping("/students/new")
	public String NewStudent(Model model) {
		Student std = new Student();
		model.addAttribute("student", std);
		return "add_student";
	}
	
	
	@PostMapping("/students")
	public String SaveStudent(@ModelAttribute("std") Student std) {
		studentService.saveStudent(std);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String edit_Student(@PathVariable Long id,Model model ) {
		model.addAttribute("Student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
	
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
	
	
	
	
	
}
