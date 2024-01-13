package net.javaguides.springboot.backend.model.mongo;

public class ReviewUpdateRequestMongo {
    private String reviewTxt;
    private String roomMongoID;

   private String customerMongoId;



    public ReviewUpdateRequestMongo() {
    }

    public ReviewUpdateRequestMongo(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }


    public String getRoomMongoID() {
        return roomMongoID;
    }

    public void setRoomMongoID(String roomMongoID) {
        this.roomMongoID = roomMongoID;
    }

    public String getCustomerMongoId() {
        return customerMongoId;
    }

    public void setCustomerMongoId(String customerMongoId) {
        this.customerMongoId = customerMongoId;
    }
}
