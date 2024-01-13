package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.RoomMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomMongoRepository extends MongoRepository<RoomMongo, String> {


    public RoomMongo findByRoomMongoID(String roomMongoID);
}
