/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.yandex.shad.socnet.repository.group.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import ua.yandex.shad.socnet.domain.group.Group;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.group.GroupRepository;
import ua.yandex.shad.socnet.repository.jdbc.ConnectionFactory;

import static ua.yandex.shad.socnet.repository.jdbc.DAOJDBCUtil.*;

/**
 *
 * @author andrii
 */
public class GroupRepositoryJDBC implements GroupRepository{
    private ConnectionFactory cnnFactory;

    public Group find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean create(Group group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addStudentToGroup(Group group, Student student) {
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Student "
                    + "(name, year) VALUES (?, ?)");
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setInt(2, student.getStudentYear());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }
    
}
