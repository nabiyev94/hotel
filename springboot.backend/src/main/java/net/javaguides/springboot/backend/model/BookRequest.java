package net.javaguides.springboot.backend.model;

import java.time.LocalDate;

public class BookRequest {

    private int categoryId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfRooms;
    private String email;

    // Constructors, getters, and setters

    public BookRequest() {
        // Default constructor
    }

    public BookRequest(int categoryId, LocalDate checkInDate, LocalDate checkOutDate,
                              int numberOfRooms) {
        this.categoryId = categoryId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfRooms = numberOfRooms;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategory(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
