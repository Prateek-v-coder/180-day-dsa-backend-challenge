package com.prateek.DAO;
import com.prateek.DB.DBConnection;
import com.prateek.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final Connection con = DBConnection.getInstance().getConnection();
    // Add book
    public void addBook(Book book){
        String query = "INSERT INTO books " +
                "(title,author,quantity," +
                "available) VALUES(?,?,?,?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getQuantity());
            ps.setInt(4,book.getAvailable());
            ps.executeUpdate();
            System.out.println("book added! "+book.getTitle());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //Get All Books
    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();
        String query = "SELECT * FROM books";
        try(PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                list.add(new Book(rs.getInt("id"),
                                  rs.getString("title"),
                                  rs.getString("author"),
                                  rs.getInt("quantity"),
                                  rs.getInt("available")
                ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    // search by title
    public void search(String title){
        String query = "SELECT * FROM books WHERE title LIKE ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,"%"+title+"%");
            ResultSet rs = ps.executeQuery();
            System.out.println("Search results:");
            while(rs.next()){
                System.out.println(rs.getInt("id")+
                        " | "+rs.getString("title")+
                        " | "+rs.getString("author")+
                        " | "+"Available: "
                        +rs.getInt("available"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // Delete Book
    public void delete(int id){
        String query = "DELETE FROM books where id=?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,id);
            int row = ps.executeUpdate();
            if(row>0){
                System.out.println("Book is deleted: id ="+ id);
            }else{
                System.out.println("Book not found");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
