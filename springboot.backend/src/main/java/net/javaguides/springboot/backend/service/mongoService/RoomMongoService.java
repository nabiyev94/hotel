package net.javaguides.springboot.backend.service.mongoService;

import net.javaguides.springboot.backend.model.mongo.RoomMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.RoomMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomMongoService {

    @Autowired
    private RoomMongoRepository roomMongoRepository;

    public List<RoomMongo> getAllRooms() {
        return roomMongoRepository.findAll();
    }

    public RoomMongo createRoom(RoomMongo roomMongo) {
        return roomMongoRepository.save(roomMongo);
    }
}
