package net.javaguides.springboot.backend.model.mongo;

public class CopyRoomAndCategory {

    private String categoryMongoId;

    private String roomMongoID;


    public String getCategoryId() {
        return categoryMongoId;
    }

    public void setCategoryMongoId(String categoryMongoId) {
        this.categoryMongoId = categoryMongoId;
    }

    public String getRoomMongoID() {
        return roomMongoID;
    }

    public void setRoomMongoID(String roomMongoID) {
        this.roomMongoID = roomMongoID;
    }
}
