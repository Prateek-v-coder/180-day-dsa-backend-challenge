package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book_DB {
    public static void getAllBook(){
        String query = "SELECT * FROM book";
        try(Connection con = DBConnection.getConnection();
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
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void getBookByPrice(double minPrice){
        String query = "SELECT * FROM book WHERE price >"+minPrice+" ORDER BY price ASC";
        try(Connection con = DBConnection.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs =stmt.executeQuery(query);) {
            System.out.println("ID | Title | Author | Price");
            System.out.println("=================================================================");
            while (rs.next()) {
                // id,title, author, price
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        getAllBook();
        System.out.println("books above 1500");
        getBookByPrice(1500);
    }
}
