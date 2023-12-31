package com.example.twitterBacked.model;



public class UserDetails {

    int id;
    String email;
    String name;
    int age;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails(int id, String email, String name, int age, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
