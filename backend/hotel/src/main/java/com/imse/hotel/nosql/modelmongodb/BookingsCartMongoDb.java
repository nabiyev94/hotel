package com.imse.hotel.nosql.modelmongodb;

public class BookingsCartMongoDb {

    private double totalPrice;
    private int roomQuantity;

    public BookingsCartMongoDb() {
    }

    public BookingsCartMongoDb(double totalPrice, int roomQuantity) {
        this.totalPrice = totalPrice;
        this.roomQuantity = roomQuantity;
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
}
