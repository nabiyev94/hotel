package net.javaguides.springboot.backend.repository.mongoRepository;

import net.javaguides.springboot.backend.model.mongo.AdministratorMongo;
import net.javaguides.springboot.backend.model.mongo.ReviewMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewMongoRepository extends MongoRepository<ReviewMongo, String> {
 /*   @Aggregation(pipeline = {
            "{ $match: { 'customerMongo.firstName': ?0 } }",
            "{ $group: { _id: '$roomMongo.roomId', count_of_reviews: { $sum: 1 } } }",
            "{ $sort: { count_of_reviews: -1 } }",
            "{ $project: { _id: 0, roomId: '$_id', count_of_reviews: 1 } }",
            "{ $merge: { into: 'mostReviewedRooms', whenMatched: 'merge', whenNotMatched: 'insert' } }"
    })
    List<Object> findMostReviewedRooms(String firstName);*/

  //  List<Object[]> findMostReviewedRooms(String firstName);
  ReviewMongo findByReviewTxt(String reviewTxt);

}