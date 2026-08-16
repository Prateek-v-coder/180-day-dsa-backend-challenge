package com.prateek.dao;
import com.prateek.DB.DBConnection;
import com.prateek.Model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    private Connection con = DBConnection.getInstance().getConnection();
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
}
