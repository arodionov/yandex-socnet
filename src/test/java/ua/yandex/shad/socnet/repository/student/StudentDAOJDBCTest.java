package ua.yandex.shad.socnet.repository.student;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.DAOTestsTemplate;

public class StudentDAOJDBCTest extends DAOTestsTemplate {

    @Autowired
    private StudentRepository studentRepository;

    @Before
    public void clearDB() {
        jdbcTemplate.execute("TRUNCATE TABLE Student");
    }

    @Test
    public void testCreateStudentNoExceptions() {
        Student stud = new Student("ABC", 1);
        Assert.assertTrue(studentRepository.create(stud));
    }

    @Test
    public void testCreateStudentThrowAndCatchException() {
        Student stud = new Student("ABC", 1);
        jdbcTemplate.execute("ALTER TABLE Student ALTER COLUMN name RENAME TO somename");

        Assert.assertFalse(studentRepository.create(stud));
        jdbcTemplate.execute("ALTER TABLE Student ALTER COLUMN somename RENAME TO name");
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

    @Test
    public void testDeleteStudent() {
        Student stud = new Student("AB", 1);
        studentRepository.create(stud);

        List<Student> students = studentRepository.findAll();
        Assert.assertEquals(1, students.size());

        int deletedRows = studentRepository.delete(students.get(0).getStudentID());
        Assert.assertEquals(1, deletedRows);
        students = studentRepository.findAll();
        Assert.assertEquals(0, students.size());
    }

    @Test
    public void testDeleteAllStudents() {
        Student stud1 = new Student("AB", 1);
        Student stud2 = new Student("BC", 2);
        Student stud3 = new Student("CD", 3);
        studentRepository.create(stud1);
        studentRepository.create(stud2);
        studentRepository.create(stud3);

        List<Student> students = studentRepository.findAll();
        
        int deletedRows = studentRepository.delete(students.get(0).getStudentID());
        Assert.assertEquals(1, deletedRows);
        students = studentRepository.findAll();
        Assert.assertEquals(2, students.size());
    }

}
