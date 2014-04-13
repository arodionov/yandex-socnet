/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.repository.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Amdrii
 */
public interface ConnectionFactory {    
       
    public Connection getConnection() throws SQLException;
    public void closeConnection(Connection conn);

}
