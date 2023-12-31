package com.example.twitterBacked.dao;




import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_details")
public class UserDetailsDao {


    int id;
    @Id
    String email;
    String name;
    int age;
    String password;

    public UserDetailsDao(int id, String email, String name, int age, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public UserDetailsDao() {
    }
}


