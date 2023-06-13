package com.imse.hotel.sql.model;

import java.time.LocalDate;

public class RoomReviewingRequest {

    private Long roomReviewingID;
    private String customer_id;
    private String room_id;
    private String reviewText;

    private LocalDate reviewDate = LocalDate.now();


    public Long getRoomReviewingID() {
        return roomReviewingID;
    }

    public void setRoomReviewingID(Long roomReviewingID) {
        this.roomReviewingID = roomReviewingID;
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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
}
