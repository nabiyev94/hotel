package com.imse.hotel.sql.model;

import java.time.LocalDate;

public class BookedRoomByCustomer {

    private String customerID;
    private String roomId;
    private String checkOutDate;

    public BookedRoomByCustomer() {
    }

    public BookedRoomByCustomer(String customerID, String roomId, String checkOutDate) {
        this.customerID = customerID;
        this.roomId = roomId;
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "BookedRoomByCustomer{" +
                "customerID='" + customerID + '\'' +
                ", roomId='" + roomId + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
