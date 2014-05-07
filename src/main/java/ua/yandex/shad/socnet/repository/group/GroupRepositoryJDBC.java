package ua.yandex.shad.socnet.repository.group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.yandex.shad.socnet.domain.group.Group;
import ua.yandex.shad.socnet.domain.student.Student;
import static ua.yandex.shad.socnet.repository.jdbc.DAOJDBCUtil.*;

/**
 *
 * @author andrii
 */
@Repository("groupRepository")
public class GroupRepositoryJDBC implements GroupRepository {

    private DataSource ds;

    @Autowired
    public GroupRepositoryJDBC(DataSource ds) {
        this.ds = ds;
    }

    public Group find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(Group group) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Groups "
                    + "(name) VALUES (?)");
            preparedStatement.setString(1, group.getGroupName());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    @Override
    public boolean addStudentToGroup(int groupID, int studentID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ds.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO student_groups_junction "
                    + "(student_id, group_id) VALUES (?, ?)");
            preparedStatement.setInt(1, studentID);
            preparedStatement.setInt(2, groupID);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

}
