package net.javaguides.springboot.backend.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    @Entity
    @Table(name = "book")
    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "bookingId")
        private long bookingId;

        @Column(name = "checkInDate")
        private LocalDate checkInDate;

        @Column(name = "checkOutDate")
        private LocalDate checkOutDate;

        @ManyToOne
        @JoinColumn(name = "roomId")
       private Room room;

        @ManyToOne
        @JoinColumn(name = "customerId")
        private Customer customer;

   



        public Book() {
        }

        public Book(LocalDate checkInDate, LocalDate checkOutDate, Room room, Customer customer) {
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.room = room;
            this.customer = customer;
        }

        public long getBookingId() {
            return bookingId;
        }

        public void setBookingId(long bookingId) {
            this.bookingId = bookingId;
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
