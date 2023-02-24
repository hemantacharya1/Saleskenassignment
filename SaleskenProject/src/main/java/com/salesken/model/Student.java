package com.salesken.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "student")
public class Student {

	@Id
	private Integer roll;
	private String name;
	private String gender;
	private Integer age;
	private String address;
	private String email;
	
	@Field(type = FieldType.Nested)
	private List<Semester> semesters=new ArrayList<>();


	public Student(int rollNumber, String name, String gender, String address, String email) {
		// TODO Auto-generated constructor stub
		this.roll=rollNumber;
		this.name=name;
		this.gender=gender;
		this.address=address;
		this.email=email;
	}

}
