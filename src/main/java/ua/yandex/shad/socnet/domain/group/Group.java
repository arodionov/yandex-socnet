/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.domain.group;

import ua.yandex.shad.socnet.domain.student.Student;
import java.util.List;

/**
 *
 * @author Amdrii
 */
public class Group {
    Integer groupID;
    String groupName;
    List<Student> students;

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }    
}
