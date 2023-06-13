package com.imse.hotel.sql.service;

import com.imse.hotel.sql.model.Category;
import com.imse.hotel.sql.model.Room;
import com.imse.hotel.sql.model.RoomRequest;
import com.imse.hotel.sql.repository.CategoryRepository;
import com.imse.hotel.sql.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

    public Room addRoomToDB(RoomRequest room){

        Category category = this.categoryRepository.findById(Integer.parseInt(room.getCategory_id())).get();
        Room tempRoom = new Room();
        tempRoom.setAvailable(room.isAvailable());
        tempRoom.setRoomNumber(room.getRoomNumber());
        tempRoom.setCategory(category);

        return this.roomRepository.save(tempRoom);
    }
}
