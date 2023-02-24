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
	private String roll;
	
	@Field(type = FieldType.Text)
	private String name;
	
	@Field(type = FieldType.Text)
	private String gender;
	
	@Field(type = FieldType.Text)
	private String address;
	
	@Field(type = FieldType.Text)
	private String email;
	
	@Field(type = FieldType.Nested)
	private List<Semester> semesters=new ArrayList<>();

	public Student(String roll, String name, String gender, String address, String email) {
		super();
		this.roll = roll;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
	}

	
}
