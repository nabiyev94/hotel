package net.javaguides.springboot.backend.model.mongo;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Document
public class RoomMongo {

    @Id
    private String roomMongoID;
    private String price;



    private String adminId;

    private String categoryMongoId;

   // private String roomid;


    public RoomMongo() {

    }



    public RoomMongo( String price) {

        this.price = price;
      //  this.roomid = roomid;
    }

    public String getRoomMongoID() {
        return roomMongoID;
    }

    public void setRoomMongoID(String roomMongoID) {
        this.roomMongoID = roomMongoID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getCategoryMongoId() {
        return categoryMongoId;
    }

    public void setCategoryMongoId(String categoryMongoId) {
        this.categoryMongoId = categoryMongoId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }



}
