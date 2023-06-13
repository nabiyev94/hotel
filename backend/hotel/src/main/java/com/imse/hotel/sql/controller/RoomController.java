package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.Room;
import com.imse.hotel.sql.model.RoomRequest;
import com.imse.hotel.sql.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @GetMapping("/getAllRooms")
    public List<Room> getAllRooms(){
        return this.roomService.getAllRooms();
    }


    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody RoomRequest room){
        return this.roomService.addRoomToDB(room);
    }
}
