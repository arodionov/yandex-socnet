package ua.yandex.shad.socnet.repository.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.repository.jdbc.ConnectionFactory;
import static ua.yandex.shad.socnet.repository.jdbc.DAOJDBCUtil.*;

@Repository
public class StudentRepositoryJDBC implements StudentRepository {

    @Autowired
    private ConnectionFactory cnnFactory;

    public StudentRepositoryJDBC() {
    }
       
    public StudentRepositoryJDBC(ConnectionFactory cnnFactory) {
        this.cnnFactory = cnnFactory;
    }

    public void setCnnFactory(ConnectionFactory cnnFactory) {
        this.cnnFactory = cnnFactory;
    } 
    
    @Override
    public Student find(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from Student where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = (map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> students = new ArrayList<Student>();

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from Student");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return students;
    }

    @Override
    public boolean create(Student student) {
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

    private Student map(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setStudentID(resultSet.getInt(1));
        student.setStudentName(resultSet.getString(2));
        student.setStudentYear(resultSet.getInt(3));
        return student;
    }

    @Override
    public Student findByName(String studentName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = null;

        try {
            connection = cnnFactory.getConnection();
            preparedStatement = connection.
                    prepareStatement("select * from Student where name = ?");
            preparedStatement.setString(1, studentName);
            resultSet = preparedStatement.executeQuery();
                      
            if(resultSet.next()) {
                student = map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return student;
    }
}
