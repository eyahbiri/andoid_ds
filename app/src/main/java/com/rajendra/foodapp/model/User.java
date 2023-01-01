package com.rajendra.foodapp.model;

public class User {
    // Attributs
    private String firstName, lastName, password, phoneNumber;
    // Params constructor
    public User(String firstName, String lastname,String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }
    // default constructor
    public User() {
        this.firstName="";
        this.lastName="";
        this.phoneNumber="";
        this.password="";
    }
    // getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
