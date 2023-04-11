package com.spring.jdbc.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImp implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int insert(Student student) {
		//insert student into the table
		String query = "insert into Student(id,name,city) values (?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	public int change(Student student) {
		
		//update data
		String query = "update Student set name=? , city = ? where id = ?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	
	public int remove(int studentId) {
		// to delete the data
		String query = "delete from Student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}

	
	public List<Student> allStudents() {
		//select multiple 
		String query = "select * from Student";
		 List<Student> students =  this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	//Select method using Row mapper
	public Student getStudent(int studentId) {
		// TSelect Single student data
		
		String query = "select * from Student where id =?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}






	
	
}
