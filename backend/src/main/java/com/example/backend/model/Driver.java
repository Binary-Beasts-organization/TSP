package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Driver {
 @Id
 @GeneratedValue
private Long id;
private String userName;
 private String password;
private String Name;
private boolean PartTimeOrFullTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isPartTimeOrFullTime() {
        return PartTimeOrFullTime;
    }

    public void setPartTimeOrFullTime(boolean partTimeOrFullTime) {
        PartTimeOrFullTime = partTimeOrFullTime;
    }
}
