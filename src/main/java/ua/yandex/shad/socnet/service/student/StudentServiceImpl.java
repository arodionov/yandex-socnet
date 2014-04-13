/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.service.student;

import java.util.List;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.student.StudentRepository;

/**
 *
 * @author andrii
 */
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    public Student findByID(Integer id) {
        return repository.find(id);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public boolean create(Student student) {
        return repository.create(student);
    }

    public Student findByName(String studentName) {
        return repository.findByName(studentName);
    }

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

}
