package com.imse.hotel.sql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    private String firstName;
    private String lastName;
    private String cutomerEmailAdress;
    private String password;
    private LocalDate birthday;
    private int age;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<BookedRoom> bookedRooms = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<RoomReviewing> reviewedRooms = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String cutomerEmailAdress, String password, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cutomerEmailAdress = cutomerEmailAdress;
        this.password = password;
        this.birthday = birthday;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

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

    public String getCutomerEmailAdress() {
        return cutomerEmailAdress;
    }

    public void setCutomerEmailAdress(String cutomerEmailAdress) {
        this.cutomerEmailAdress = cutomerEmailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {

        this.birthday = birthday;

        LocalDate localDate = LocalDate.now();
        this.age = Period.between(this.birthday, localDate).getYears();

    }

    public List<BookedRoom> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(List<BookedRoom> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public List<RoomReviewing> getReviewedRooms() {
        return reviewedRooms;
    }

    public void setReviewedRooms(List<RoomReviewing> reviewedRooms) {
        this.reviewedRooms = reviewedRooms;
    }

    public int getAge() {
        return age;
    }

}
