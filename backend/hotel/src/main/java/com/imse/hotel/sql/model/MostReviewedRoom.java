package com.imse.hotel.sql.model;

public class MostReviewedRoom {

    private String room_id;

    private String category_id;
    private String counter_of_Reviews;


    public MostReviewedRoom(String room_id, String cat_id, String counter) {
        this.room_id = room_id;
        this.category_id = cat_id;
        this.counter_of_Reviews = counter;
    }


    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCounter_of_Reviews() {
        return counter_of_Reviews;
    }

    public void setCounter_of_Reviews(String counter_of_Reviews) {
        this.counter_of_Reviews = counter_of_Reviews;
    }

    @Override
    public String toString() {
        return "MostReviewedRoom{" +
                "room_id='" + room_id + '\'' +
                ", category_id='" + category_id + '\'' +
                ", counter_of_Reviews='" + counter_of_Reviews + '\'' +
                '}';
    }
}
