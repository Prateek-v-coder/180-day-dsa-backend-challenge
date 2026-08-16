package com.prateek.Model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;
    private int available;
    public Book(String title,String author,int quantity){
        this.title=title;
        this.author=author;
        this.quantity=quantity;
        this.available=quantity;
    }
    public Book(int id,String title,String author, int quantity,int available){
        this.id=id;
        this.title=title;
        this.author=author;
        this.quantity=quantity;
        this.available=available;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getAvailable(){
        return available;
    }

   @Override
    public String toString(){
        return id+" | "+ title +
                  " | "+ author +
                  " | Qty: " +
                  " | Available: " + available;
   }
}
