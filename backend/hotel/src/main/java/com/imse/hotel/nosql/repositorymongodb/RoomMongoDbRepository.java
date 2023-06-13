package com.imse.hotel.nosql.repositorymongodb;

import com.imse.hotel.nosql.modelmongodb.RoomMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomMongoDbRepository extends MongoRepository<RoomMongoDb, String> {

    public RoomMongoDb findByRoomId(String roomId);
}
