package net.javaguides.springboot.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = " review ")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    @Column(name = " reviewTxt ")
    private String reviewTxt;
    @Column(name = " date ")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = " roomId ", referencedColumnName = "roomId")
    private Room room;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    public Review() {
    }

    public Review(String reviewTxt,  LocalDate date, Room room, Customer customer) {
        this.reviewTxt = reviewTxt;
        this.date = date;
        this.room = room;
        this.customer = customer;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
