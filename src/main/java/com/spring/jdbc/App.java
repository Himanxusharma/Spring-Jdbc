package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
       StudentDao  studentDao =  context.getBean("studentDao",StudentDao.class);
       
       Student student =  new Student();
       
       // INSERT
//       student.setId(3);
//       student.setName("Karry");
//       student.setCity("Kharagpur");
//       int result = studentDao.insert(student);
//       
//       System.out.println("student added  : "+result);
       
       
       // UPDATE
//       student.setId(3);
//       student.setName("karishma");
//       student.setCity("Kharagpur UK");
//       int result = studentDao.change(student);
//       
//       System.out.println("student updated  : "+result);
       
       
       
       // DELETE
       int result = studentDao.remove(3);
       
       System.out.println("successfully deleted  : "+result);

    }
}
