package com.example.accessingdatajpa;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "addressbookId")
    private AddressBook addressBook;

    /* Constructor
     */
    public BuddyInfo(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public BuddyInfo() {
        this("", "", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public boolean equals(BuddyInfo buddy) {
        if(buddy == null) return false;
        if(buddy == this) return true;
        if(buddy.getClass() != this.getClass()) return false;
        BuddyInfo bud = (BuddyInfo)buddy;
        if(bud.getAddress().equals(this.address) && bud.getName().equals(this.name) && bud.getPhone().equals(this.phone)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "{Name: " + this.name + ", Phone: " + this.phone + ", Address: " + this.address + "}";
    }

}