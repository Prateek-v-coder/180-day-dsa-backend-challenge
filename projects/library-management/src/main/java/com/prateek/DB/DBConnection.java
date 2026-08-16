package com.prateek.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASS = "";
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
