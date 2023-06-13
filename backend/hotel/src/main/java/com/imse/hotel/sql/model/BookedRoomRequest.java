package com.imse.hotel.sql.model;

import java.time.LocalDate;

public class BookedRoomRequest {

    private Long bookedRoomID;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String customer_id;
    private String room_id;


    public Long getBookedRoomID() {
        return bookedRoomID;
    }

    public void setBookedRoomID(Long bookedRoomID) {
        this.bookedRoomID = bookedRoomID;
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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
}
