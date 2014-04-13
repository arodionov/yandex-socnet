/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.service.student;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.student.StudentRepository;

/**
 *
 * @author andrii
 */
public class StudentServiceImplTest {

    @Test
    public void testCheckIfExistsWithNull() {
        StudentRepository repository = mock(StudentRepository.class);
        StudentService service = new StudentServiceImpl(repository);
        Student student = null;

        assertFalse(service.checkIfExists(student));
    }

    @Test
    public void testCheckIfExistsCheckingByIDExists() {
        int studID = 1111;
        Student student = new Student("Andrii", 4);
        student.setStudentID(studID);

        StudentRepository repository = mock(StudentRepository.class);
        when(repository.find(studID)).thenReturn(student);
        
        StudentService service = new StudentServiceImpl(repository);

        assertTrue(service.checkIfExists(student));
    }    
    
    @Test
    public void testCheckIfExistsCheckingByIDNotExists() {
        int studID = 0000;
        Student student = new Student("Andrii", 4);
        student.setStudentID(studID);

        StudentRepository repository = mock(StudentRepository.class);
        when(repository.find(studID)).thenReturn(null);
        
        StudentService service = new StudentServiceImpl(repository);

        assertFalse(service.checkIfExists(student));
    }
    
    @Test
    public void testCheckIfExistsCheckingWithoutIDByAllFieldsExists() {
        String studName = "Andrii";
        int studYear = 4;
        Student student = new Student(studName, studYear);
        
        StudentRepository repository = mock(StudentRepository.class);
        when(repository.findByName(studName)).thenReturn(student);
        
        StudentService service = new StudentServiceImpl(repository);

        assertTrue(service.checkIfExists(student));
    }    
    
    @Test
    public void testCheckIfExistsCheckingWithoutIDByAllFieldsNotExistsYear() {
        String studName = "Andrii";
        int studYear = 4;
        Student student = new Student(studName, studYear);
        Student studentReturn = new Student(studName, studYear+1);
        
        StudentRepository repository = mock(StudentRepository.class);
        when(repository.findByName(studName)).thenReturn(studentReturn);
        
        StudentService service = new StudentServiceImpl(repository);

        assertFalse(service.checkIfExists(student));
    }    

}
