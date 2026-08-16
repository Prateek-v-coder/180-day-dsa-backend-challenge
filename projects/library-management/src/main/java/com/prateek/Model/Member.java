package com.prateek.Model;

public class Member {
    private int id;
    private String name;
    private String email;
    private String phone;
    public Member(String name, String email, String phone){
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
    public Member(int id,String name, String email, String phone){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String toString(){
        return id+" | "+ name  +
                  " | "+ email +
                  " | "+ phone;
    }
}
