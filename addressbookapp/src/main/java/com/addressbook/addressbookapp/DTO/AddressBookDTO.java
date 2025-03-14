package com.addressbook.addressbookapp.DTO;

//Section-02(UC-1)
public class AddressBookDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    // Constructors, Getters, and Setters
    public AddressBookDTO() {
    }

    public AddressBookDTO(Long id, String name, String phoneNumber, String email) {
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
