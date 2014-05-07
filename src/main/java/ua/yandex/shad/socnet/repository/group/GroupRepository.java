package ua.yandex.shad.socnet.repository.group;

import java.util.List;
import ua.yandex.shad.socnet.domain.group.Group;

/**
 *
 * @author Amdrii
 */
public interface GroupRepository {
    Group find(Integer id);
    List<Group> findAll();
    boolean create(Group group);    
    boolean addStudentToGroup(int groupID, int studentID);
}
