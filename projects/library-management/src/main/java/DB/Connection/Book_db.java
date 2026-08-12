package DB.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book_db {
    public static void getAllBook(){
        String query = "SELECT * FROM book";
        try(Connection con = DB_connection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);){
            System.out.println("ID | Title | Author | Price");
            System.out.println("=================================================================");
            while(rs.next()) {
                // id,title, author, price
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price"));
            }
            System.out.println("=================================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        getAllBook();
    }
}
