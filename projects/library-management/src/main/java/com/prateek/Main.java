package com.prateek;
import com.prateek.DAO.BookDAO;
import com.prateek.Model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO book = new BookDAO();
//        book.addBook(new Book("Java programing","James Gosling",3));
//        book.addBook(new Book("DSA in Java","prateek verma",3));
        //   System.out.println("\n=== All Books ===");
//        List<Book> list = book.getAllBooks();
//        for(Book b:list){
//            System.out.println(b);
//        }
        System.out.println(" search book: ");
        book.search("Java");
        System.out.println("deleting book title = 3 , 4");
        book.delete(3);
        book.delete(4);
        book.search("Java");
    }
}