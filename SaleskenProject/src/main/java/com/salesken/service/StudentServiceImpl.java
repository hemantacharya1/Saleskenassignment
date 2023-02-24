package com.salesken.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.model.MarksReportDTO;
import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo sRepo;
	
	
	@Override
	public Student createStudent(Student student) {
		
		Semester sem1=new Semester(1,0,0,0);
		Semester sem2=new Semester(2,0,0,0);
		student.getSemesters().add(sem1);
		student.getSemesters().add(sem2);
		
		return sRepo.save(student);
		
	}

	@Override
	public MarksReportDTO averageReports(Integer semesterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMarks(Integer studentId, Semester semester) {
		// TODO Auto-generated method stub
		Student student=sRepo.findByRoll(studentId);
		
		if(semester.getEnglish()>100 || semester.getMaths()>100 || semester.getScience()>100) {
			throw new RuntimeException("Subject marks can not be greater than 100");
		}
		student.getSemesters().get(semester.getId()-1).setEnglish(semester.getEnglish());
		student.getSemesters().get(semester.getId()-1).setMaths(semester.getMaths());
		student.getSemesters().get(semester.getId()-1).setScience(semester.getScience());
		
		sRepo.save(student);
	}

	@Override
	public List<Student> topTwoStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
