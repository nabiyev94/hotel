package net.javaguides.springboot.backend.controller.mongoController;

import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.model.mongo.RoomMongo;
import net.javaguides.springboot.backend.service.mongoService.RoomMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class RoomMongoController {

    @Autowired
    private RoomMongoService roomMongoService;

    @GetMapping("/room")
    public List<RoomMongo> getAllRooms(){

        return this.roomMongoService.getAllRooms();
    }

    @PostMapping("/room")
    public RoomMongo createRoom(@RequestBody RoomMongo roomMongo) {
        return this.roomMongoService.createRoom(roomMongo);
    }



}
