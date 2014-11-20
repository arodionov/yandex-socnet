/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.service.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.student.StudentRepository;

/**
 *
 * @author andrii
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student findByID(Integer id) {
        return repository.find(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Student student) {
        return repository.create(student);
    }

    @Override
    public Student findByName(String studentName) {
        return repository.findByName(studentName);
    }

    @Override
    public boolean checkIfExists(Student stud) {
        if (stud == null
                || stud.getStudentName() == null
                || stud.getStudentYear() == null) {
            return false;
        }
        Integer studID = stud.getStudentID();
        String studName = stud.getStudentName();
        Integer studYear = stud.getStudentYear();
        if (studID != null) {
            return repository.find(studID) != null;
        } else {
            Student foundStud = repository.findByName(studName);
            return foundStud != null ? foundStud.getStudentYear().equals(studYear) : false;
        }
    }

    @Override
    public int delete(Integer studentID) {
        return repository.delete(studentID);
    }

}
