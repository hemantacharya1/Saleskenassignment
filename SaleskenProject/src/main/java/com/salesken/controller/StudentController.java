package com.salesken.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.model.Student;
import com.salesken.repo.StudentRepo;
import com.salesken.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@Autowired
	private StudentRepo sRepo;
	
	@PostMapping("/addStudents")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student saved=sService.createStudent(student);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents(){
		Iterable<Student>list=sRepo.findAll();
		List<Student> student=new ArrayList<>();
		list.forEach(student::add);
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
}
