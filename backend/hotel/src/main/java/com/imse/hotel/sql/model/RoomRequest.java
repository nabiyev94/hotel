package com.imse.hotel.sql.model;

public class RoomRequest {
    private String roomId;
    private int roomNumber;
    private boolean isAvailable = true;
    private String category_id;

    private Long AdminId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Long getAdminId() {
        return AdminId;
    }

    public void setAdminId(Long adminId) {
        AdminId = adminId;
    }
}
