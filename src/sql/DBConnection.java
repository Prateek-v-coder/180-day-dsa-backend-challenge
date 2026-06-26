package sql;
import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String User_Name = "root";
    private static final String PassWord = "Rat*#9653";
   public static Connection getConnection () throws SQLException{
       return DriverManager.getConnection(URL,User_Name,PassWord);
   }

}
