package com.imse.hotel.sql.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "bookedRoom")
@Table(name = "bookedRoom")
public class BookedRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookedRoomID;

    /*
    @EmbeddedId
    private BookedRoomID bookedRoomID = new BookedRoomID();
*/

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    public BookedRoom() {
    }

    public BookedRoom(/*long bookingID,*/ Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        //this.bookingID = bookingID;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

    public int getBookedRoomID() {
        return bookedRoomID;
    }
}
