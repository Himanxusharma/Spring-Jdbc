package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;


public interface StudentDao {
	
	public int insert(Student student);
	public int change(Student student);
	public int remove(int studentId);
	public Student getStudent(int studentId);
	
	public List<Student> allStudents();
}
