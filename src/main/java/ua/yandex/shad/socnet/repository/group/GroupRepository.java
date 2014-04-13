/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.repository.group;

import java.util.List;
import ua.yandex.shad.socnet.domain.group.Group;
import ua.yandex.shad.socnet.domain.student.Student;


/**
 *
 * @author Amdrii
 */
public interface GroupRepository {
    Group find(Integer id);
    List<Group> findAll();
    boolean create(Group group);
    boolean addStudentToGroup(Group group, Student student);
    //boolean update(Group group);
}
