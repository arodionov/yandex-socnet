package ua.yandex.shad.socnet.repository.student;

import java.util.List;
import ua.yandex.shad.socnet.domain.student.Student;

/**
 *
 * @author Amdrii
 */
public interface StudentRepository {
    Student find(Integer id);
    List<Student> findAll();
    boolean create(Student student);
    Student findByName(String studentName);
    //boolean upadate(Student student);
    //List<Student> findAllInGroup(Integer groupID);
    //List<Student> findAllInGroup(Group group);
    
}
