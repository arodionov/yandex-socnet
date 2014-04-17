package ua.yandex.shad.socnet.repository.student.jdbc;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.jdbc.DAOTestsTemplate;
import ua.yandex.shad.socnet.repository.student.StudentRepository;


public class StudentDAOJDBCTest extends DAOTestsTemplate{
    
    @Autowired
    private StudentRepository studentRepository;
    
    
    @Before
    public void clearDB(){
        jdbcTemplate.execute("TRUNCATE TABLE Student");
    }    
   
    @Test
    public void testCreateStudentNoExceptions() {
        Student stud = new Student("ABC", 1);                
        studentRepository.create(stud);
    }
    
    @Test
    public void testCreateStudent() {
        Student stud = new Student("ABC", 1);                
        studentRepository.create(stud);
        
        int size = jdbcTemplate.queryForObject("select count(*) from Student", Integer.class);
        Assert.assertEquals(1, size);
    }
    
    
    @Test   
    public void testFindByNameStudent() {
        Student stud = new Student("ABC", 1); 
        studentRepository.create(stud);
        
        Student actualResult = studentRepository.findByName("ABC");
        Assert.assertEquals(stud, actualResult);
    }
    
    @Test       
    public void testFindAllStudents() {  
        Student stud1 = new Student("ABC", 1); 
        Student stud2 = new Student("BC", 2);
        studentRepository.create(stud1);
        studentRepository.create(stud2);
        
        List<Student> actualResult = studentRepository.findAll();
        Assert.assertEquals(2, actualResult.size());
    }    
}
