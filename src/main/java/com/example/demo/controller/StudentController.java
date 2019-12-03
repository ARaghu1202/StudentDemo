package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/name", method = {RequestMethod.GET})
	public String getStudentName() {
		
		return studentService.getName();
	}
	
	@PostMapping("/students")
    private int savePerson(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
        return student.getId();
    }

}
