package com.addressbook.addressbookapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Section-02(UC-1)
@Entity
public class AddressBookModel {

    @Id
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    // Constructors, Getters and Setters
    public AddressBookModel() {
    }

    public AddressBookModel(Long id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
