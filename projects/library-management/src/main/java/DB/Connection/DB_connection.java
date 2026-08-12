package DB.Connection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String user_name = "root";
    private static final String password = "Rat*#9653";
    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(URL,user_name,password);
    }

}

