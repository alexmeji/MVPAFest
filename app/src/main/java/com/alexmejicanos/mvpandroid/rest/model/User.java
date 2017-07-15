package com.alexmejicanos.mvpandroid.rest.model;

/**
 * Created by alexmejicanos on 15/07/17.
 */

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
