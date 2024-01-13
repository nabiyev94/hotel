package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class BookMongo {

    @Id
    private String bookMongoId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;



    private String roomMongoID;
    private String customerMongoId;
   // private String customerEmail;
    public BookMongo() {
    }

    public BookMongo(String bookMongoId, LocalDate checkInDate, LocalDate checkOutDate) {
        this.bookMongoId = bookMongoId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }

    public String getBookMongoId() {
        return bookMongoId;
    }

    public void setBookMongoId(String bookMongoId) {
        this.bookMongoId = bookMongoId;
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



    public String getCustomerMongoId() {
        return customerMongoId;
    }

    public void setCustomerMongoId(String customerMongoId) {
        this.customerMongoId = customerMongoId;
    }

    public String getRoomMongoID() {
        return roomMongoID;
    }

    public void setRoomMongoID(String roomMongoID) {
        this.roomMongoID = roomMongoID;
    }
}

