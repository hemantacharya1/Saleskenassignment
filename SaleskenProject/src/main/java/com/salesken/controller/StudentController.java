package com.salesken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.model.Student;
import com.salesken.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student saved=sService.createStudent(student);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
}
