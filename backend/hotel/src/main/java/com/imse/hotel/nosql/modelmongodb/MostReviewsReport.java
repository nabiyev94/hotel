package com.imse.hotel.nosql.modelmongodb;

public class MostReviewsReport {

    private String room_id;
    private String category_id;
    private String counter_of_Reviews;

    public MostReviewsReport() {
    }

    public MostReviewsReport(String room_id, String category_id, String counter_of_Reviews) {
        this.room_id = room_id;
        this.category_id = category_id;
        this.counter_of_Reviews = counter_of_Reviews;
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
        return "MostReviewsReport{" +
                "room_id='" + room_id + '\'' +
                ", category_id='" + category_id + '\'' +
                ", counter_of_Reviews='" + counter_of_Reviews + '\'' +
                '}';
    }
}
