package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentServiceImpl;

@RestController
public class StudentController {
    @Autowired
	private StudentServiceImpl studentServiceImpl;
	
    @GetMapping("/students")
	public List<Student> getAllStudents() {
		return this.studentServiceImpl.getAllStudents();
		
	}
    @GetMapping("/students/{sid}")
    public Student getStudentById(@PathVariable String sid) {
    	return this.studentServiceImpl.getStudentById(Long.parseLong(sid));
		
	}
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s) {
    	return this.studentServiceImpl.addStudent(s);
    }
    @PutMapping("/students")
    public Student updaStudent(@RequestBody Student s) {
    	return this.studentServiceImpl.updateStudent(s);
    }
    @DeleteMapping("/students/{sid}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable String sid){
    	try {
    	this.studentServiceImpl.deleteStudentById(Long.parseLong(sid));
    	return new ResponseEntity<>(HttpStatus.OK);
    	}catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
