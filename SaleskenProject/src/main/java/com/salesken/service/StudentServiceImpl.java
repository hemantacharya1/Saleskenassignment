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
		
		Semester sem1=new Semester(1,null,null,null);
		Semester sem2=new Semester(2,null,null,null);
		student.getSemesters().add(sem1);
		student.getSemesters().add(sem2);
		
		return sRepo.save(student);
		
	}

	@Override
	public MarksReportDTO averageReports(Integer semesterId) {
		List<Student>students=(List<Student>) sRepo.findAll();
		int english=0;
		int maths=0;
		int science=0;
		int totalStudents=0;
		for(int i=0; i<students.size(); i++) {
				Integer eng=students.get(i).getSemesters().get(semesterId-1).getEnglish();
				Integer math=students.get(i).getSemesters().get(semesterId-1).getMaths();
				Integer sci=students.get(i).getSemesters().get(semesterId-1).getScience();
				if(eng==null && math==null && sci==null) {
					continue;
				}
				else {
					english+=eng; math+=maths; science+=sci;
					totalStudents++;
				}
			}
		int totalScoredMarks=english+maths+science;
		int totalMarks=totalStudents*300;
		
		Double percentile=((double)totalScoredMarks/totalMarks)*100;
		
		MarksReportDTO report=new MarksReportDTO();
		report.setEnglish((double)english/totalStudents);
		report.setMaths((double)maths/totalStudents);
		report.setScience((double)science/totalStudents);
		report.setAveragePercentile(percentile);
		return report;
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
