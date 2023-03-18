package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	private StudentRepository studentrepo;
	@Override
	public List<Student> getAllStudents() {
		return studentrepo.findAll();
		 
	}
	@Override
	public Student getStudentById(long sid) {
	   return studentrepo.findById(sid).orElse(null);
	}
	@Override
	public Student addStudent(Student s) {
		
		return studentrepo.save(s);
	}
	@Override
	public Student updateStudent(Student s) {
		return studentrepo.save(s);
	}
	@Override
	public void deleteStudentById(long sid) {
		Student entity=studentrepo.getReferenceById(sid);
		studentrepo.delete(entity);
		
	}
    
}
