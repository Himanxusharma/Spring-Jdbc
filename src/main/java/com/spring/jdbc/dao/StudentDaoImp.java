package com.spring.jdbc.dao;


import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImp implements StudentDao{

	
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

	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	
	
}
