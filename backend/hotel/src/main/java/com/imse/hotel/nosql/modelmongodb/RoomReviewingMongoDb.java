package com.imse.hotel.nosql.modelmongodb;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Document
public class RoomReviewingMongoDb {

    @Id
    private String id;

    private String reviewText;
    private LocalDate reviewDate;

    private CustomerRef customerRef;

    private String roomId;




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

    public CustomerRef getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(CustomerRef customerRef) {
        this.customerRef = customerRef;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
