package com.imse.hotel.sql.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "booking_cart")
public class BookingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    private double totalPrice;
    private int roomQuantity;

    @JsonIgnore
    @OneToOne(mappedBy = "bookingCart")
    private Customer owner;

    public BookingCart() {
    }

    public BookingCart(double totalPrice, int roomQuantity) {
        this.totalPrice = totalPrice;
        this.roomQuantity = roomQuantity;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
