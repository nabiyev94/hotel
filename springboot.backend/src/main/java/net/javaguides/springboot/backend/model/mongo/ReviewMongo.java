package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class ReviewMongo {

    @Id
    private  String reviewMongoId;
    private String reviewTxt;
    private LocalDate date;



    private String roomMongoID;
    private String customerMongoId;


    public ReviewMongo() {
    }

    public ReviewMongo(String reviewMongoId, String reviewTxt, LocalDate date) {
        this.reviewMongoId = reviewMongoId;
        this.reviewTxt = reviewTxt;
        this.date = date;

    }

    public String getReviewMongoId() {
        return reviewMongoId;
    }

    public void setReviewMongoId(String reviewMongoId) {
        this.reviewMongoId = reviewMongoId;
    }

    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
