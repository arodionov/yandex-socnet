/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.yandex.shad.socnet.service.student;

import java.util.List;
import ua.yandex.shad.socnet.domain.student.Student;

/**
 *
 * @author andrii
 */
public interface StudentService {
    Student findByID(Integer id);
    List<Student> findAll();
    boolean create(Student student);
    Student findByName(String studentName);
    boolean checkIfExists(Student stud);
    int delete(Integer studentID);
}
