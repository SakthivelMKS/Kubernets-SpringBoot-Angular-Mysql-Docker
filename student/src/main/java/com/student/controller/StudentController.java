package com.student.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api")
public class StudentController {
	
	
	@Autowired  
    private StudentService studentservice;  
	
	@RequestMapping("/test")
	 public String customerInformation() {
	      return "Hey, I am from external tomcat";
	 }
	
	// Get All Notes
	@GetMapping("/studentList")
	public List<Student> getAllNotes() {
	    return studentservice.getStudents();
	}
	
	// Create a new Note
	@PostMapping("/student")
	public Student saveStudent( @RequestBody Student st) {
	    return studentservice.saveStudent(st);
	}
	
	@GetMapping("/student/{id}")
	public Student getNoteById(@PathVariable(value = "id") Long id) {
	    return studentservice.getStudentByID(id);
	           
	}
	
	@PutMapping("/student/{id}")
	public Student updateNote(@RequestBody Student student) {

		Student stnt = studentservice.updateStudent(student);

		
	    return stnt;
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> deleteStudent( Long id) {
	            
	    studentservice.deleteStudent(id);
	    return ResponseEntity.ok().build();
	}
	
}
