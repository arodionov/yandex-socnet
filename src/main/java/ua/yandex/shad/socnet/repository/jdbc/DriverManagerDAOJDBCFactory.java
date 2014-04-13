/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.shad.socnet.repository.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *    private static final Properties prop = new Properties();
//
//    static{
//        try {
//            //File file = new File("dao.properties");
//            //System.out.println(file.getCanonicalPath());
//            
//            prop.load(new FileReader("dao.properties"));            
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
 * @author Amdrii
 */
public class DriverManagerDAOJDBCFactory implements ConnectionFactory{

    private String driver;
    private String url;
    private String user;
    private String pass;

    public DriverManagerDAOJDBCFactory() {
    }
    
    public DriverManagerDAOJDBCFactory(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }    
    
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
        
   @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       
        return DriverManager.getConnection(url, user, pass);
    }

    public void closeConnection(Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
