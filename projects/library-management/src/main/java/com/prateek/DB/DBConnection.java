package com.prateek.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASS = "Rat*#9653";
    private DBConnection(){
        try{
            connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("DB Connected!");
        }catch (Exception e){
            System.out.println("Connection field.."+e.getMessage());
        }
    }
    public static DBConnection getInstance(){
        if(instance==null) {
            synchronized (DBConnection.class) {
                if(instance==null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }

}
