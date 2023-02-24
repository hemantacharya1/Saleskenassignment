package com.salesken.service;

import java.util.List;

import com.salesken.model.MarksReportDTO;
import com.salesken.model.Semester;
import com.salesken.model.Student;

public interface StudentService {

	public Student createStudent(Student student);
	
	public MarksReportDTO averageReports(Integer semesterId);
	
	public void setMarks(Integer studentId,Semester semester);
	
	public List<Student> topTwoStudents();
}
