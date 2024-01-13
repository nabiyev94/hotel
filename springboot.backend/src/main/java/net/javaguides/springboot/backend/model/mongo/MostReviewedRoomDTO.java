package net.javaguides.springboot.backend.model.mongo;

public class MostReviewedRoomDTO {

    private String roomMongoID;
    private String categoryMongoId;
    private int reviewCount;

    public MostReviewedRoomDTO(String roomMongoID, String categoryMongoId, int reviewCount) {
        this.roomMongoID = roomMongoID;
        this.categoryMongoId = categoryMongoId;
        this.reviewCount = reviewCount;
    }

    public String getRoomMongoID() {
        return roomMongoID;
    }

    public void setRoomMongoID(String roomMongoID) {
        this.roomMongoID = roomMongoID;
    }

    public String getCategoryMongoId() {
        return categoryMongoId;
    }

    public void setCategoryMongoId(String categoryMongoId) {
        this.categoryMongoId = categoryMongoId;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
}
