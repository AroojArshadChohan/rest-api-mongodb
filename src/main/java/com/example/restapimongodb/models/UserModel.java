package com.example.restapimongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class UserModel {

    @Id
    private String _id;
    private String username;
    private String password;

    private String firstName;
    private String lastName;

    public UserModel() {
    }

    public UserModel(String id, String username, String password, String firstName, String lastName) {
        this._id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;

        this.lastName = lastName;


    }

    public String getid() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
