package com.imse.hotel.nosql.modelmongodb;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Document
public class BookedRoomMongoDb {

    @Id
    private String id;

    private CustomerRef customerRef;

    private String roomId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;


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
}
