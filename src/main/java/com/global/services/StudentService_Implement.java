package com.global.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.global.entity.Student;
import com.global.reposetory.StudentRepo;

public class StudentService_Implement implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
	}

}
