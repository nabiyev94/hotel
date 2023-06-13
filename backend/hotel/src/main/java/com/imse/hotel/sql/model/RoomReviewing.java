package com.imse.hotel.sql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "room_reviewing")
public class RoomReviewing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomReviewingID;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    private String reviewText;

    private LocalDate reviewDate = LocalDate.now();

    public RoomReviewing() {
    }

    public RoomReviewing(Customer customer, Room room, String reviewText) {
        this.customer = customer;
        this.room = room;
        this.reviewText = reviewText;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public Long getRoomReviewingID() {
        return roomReviewingID;
    }
}
