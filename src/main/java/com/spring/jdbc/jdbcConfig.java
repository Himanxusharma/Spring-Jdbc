package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImp;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class jdbcConfig {

	@Bean("ds")
	public DataSource getDataSource ()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("himanshu");
		ds.setPassword("1234");
		
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		
		JdbcTemplate jdbcTemplate = new  JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	
	
	//WE'll use Autowiring
/*	@Bean("studentDao")
	public StudentDao getStudentDao() {
		
		StudentDaoImp studentDao = new StudentDaoImp();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		}
		
		*/
		
	
}
