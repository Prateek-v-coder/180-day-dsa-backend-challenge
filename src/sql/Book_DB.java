package sql;

import java.sql.*;

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
            System.out.println("=================================================================");
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
            System.out.println("=================================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void addBook(String title, String author, double price){
        String query = "INSERT INTO book"+" (title,author,price) "+" values(?,?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,title);
            ps.setString(2,author);
            ps.setDouble(3,price);
            int row = ps.executeUpdate();
            System.out.println(row+" book added "+title);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updatePrice(int id,double price){
        String query = "UPDATE book set price = ? "+" where id = ?";
        try(Connection con = DBConnection.getConnection();
          PreparedStatement ps = con.prepareStatement(query)){
            ps.setDouble(1,price);
            ps.setInt(2,id);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println("price updated for ID: "+id);
            }else {
                System.out.println("book not found");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteBook(int id){
        String query = "DELETE FROM book WHERE id = ?";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,id);
            int row = ps.executeUpdate();
            if(row>0){
                System.out.println("Book Deleted: ID = "+id);
            }else {
                System.out.println("Book not found  "+id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 1. Saari books dekho
        getAllBook();

        // 2. Naya book add karo
        addBook("Graphs", "Prateek", 1200.0);
        getAllBook();  // verify

        // 3. Price update karo
        updatePrice(1, 999.0);
        getAllBook();  // verify

        // 4. Book delete karo
        deleteBook(2);
        getAllBook();  // verify




    }
}
