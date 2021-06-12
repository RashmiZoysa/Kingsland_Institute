package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:sql://localhost:/3306", "root", "rash123");

    } 

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        return (null == dbConnection) ? (dbConnection = new DBConnection()) : (dbConnection);

    }

    public Connection getConnection() {
        return connection;
    }
}
