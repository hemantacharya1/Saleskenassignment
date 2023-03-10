package com.salesken.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salesken.model.MarksReportDTO;
import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentControllerUi {

	@GetMapping("/home")
	public String homeMethod() {
		return "home.jsp";
	}

	@Autowired
	private StudentService sService;

	
	
	@PostMapping("/addstudent")
	public String saveStudent(HttpServletRequest request) {
		
		Student student=new Student(request.getParameter("roll"), request.getParameter("name")
									,request.getParameter("gender"), request.getParameter("address")
									,request.getParameter("email"));
		sService.createStudent(student);
		return "home.jsp";
	}

	@RequestMapping(value = "add-marks", method = RequestMethod.POST)
	public String editMarks(HttpServletRequest request) {
		Integer roll=Integer.parseInt(request.getParameter("rollNumber"));
		
		Semester semester=new Semester(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("english")), 
											Integer.parseInt(request.getParameter("maths")) , Integer.parseInt(request.getParameter("science")));
		
		sService.setMarks(roll, semester);
		
		return "home.jsp";
	}
	
	
	@RequestMapping("/topstudents")
	public ModelAndView topTwoStudents() {
		List<Student> list=sService.topTwoStudents();
		ModelAndView model=new ModelAndView();
		model.addObject("list",list);
		model.setViewName("topstudents.jsp");
		
		return model;
	}
	
	@RequestMapping(value = "choose-semester", method = RequestMethod.POST)
	public ModelAndView averageReport(HttpServletRequest request) {
		Integer semester=Integer.parseInt(request.getParameter("semester"));
		
		MarksReportDTO report=sService.averageReports(semester);
		
		List<MarksReportDTO>list=new ArrayList<>();
		list.add(report);
		
		ModelAndView model=new ModelAndView();
		model.addObject("list",list);
		model.setViewName("averagereport.jsp");
		
		return model;
	}
}
