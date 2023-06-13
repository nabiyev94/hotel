package com.imse.hotel.nosql.modelmongodb;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class RoomReviewingMongoRequest {

    private String customerId;
    private String roomId;
    private String reviewText;

    @JsonIgnore
    private LocalDate reviewDate;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
