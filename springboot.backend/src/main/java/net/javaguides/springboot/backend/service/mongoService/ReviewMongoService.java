package net.javaguides.springboot.backend.service.mongoService;

import com.mongodb.BasicDBObject;
import net.javaguides.springboot.backend.controller.mongoController.ReviewMongoController;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.model.Review;
import net.javaguides.springboot.backend.model.ReviewUpdateRequest;
import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.model.mongo.*;
import net.javaguides.springboot.backend.repository.mongoRepository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
@Service

    public class ReviewMongoService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewMongoService.class);


        @Autowired
        ReviewMongoRepository reviewMongoRepository;

        @Autowired
        CustomerMongoRepository customerMongoRepository;

        @Autowired
        RoomMongoRepository roomMongoRepository;

        @Autowired
        CategoryMongoRepository categoryMongoRepository;

        @Autowired
        BookMongoRepository bookMongoRepository;

        @Autowired
        private MongoTemplate mongoTemplate;


/*

        public ReviewMongo addReview(String roomMongoID, String customerMongoId, ReviewUpdateRequestMongo requestMongo) {
        System.out.println("Searching for RoomMongo with Id: " + roomMongoID);
        RoomMongo roomMongo = roomMongoRepository.findById(roomMongoID)
                .orElseThrow(() -> new ResourceNotFoundException("Room with Id " + roomMongoID + " not found"));

        // Überprüfe, ob der Kunde mit der gegebenen customerMongoId existiert
        CustomerMongo customerMongo = customerMongoRepository.findById(customerMongoId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with Id " + customerMongoId + " not found"));

        // Überprüfe, ob der Kunde das Zimmer gebucht hat
        List<BookMongo> bookedRooms = bookMongoRepository.findRoomsByCustomerId(customerMongoId);
        boolean isCustomerBookedRoom = bookedRooms.stream().anyMatch(book -> book.getRoomMongoID().equals(roomMongoID));
        if (!isCustomerBookedRoom) {
            throw new ResourceNotFoundException("Customer with Id " + customerMongoId + " has not booked the room with Id " + roomMongoID);
        }

        // Erstelle die Bewertung und speichere sie
        ReviewMongo reviewMongo = new ReviewMongo();
      //  reviewMongo.setReviewTxt("txt");
        reviewMongo.setRoomMongoID(roomMongo.getRoomMongoID()); // Verwende die ObjectId des Rooms
        reviewMongo.setCustomerMongoId(customerMongo.getCustomerMongoId()); // Verwende die ObjectId des Customers
        reviewMongo.setDate(LocalDate.now());
        reviewMongo.setReviewTxt(reviewMongo.getReviewTxt());
        System.out.println("Review updated successfully");


        return reviewMongoRepository.save(reviewMongo);
    }
    */

/*
    public ReviewMongo addReview(String roomid, String customerid, ReviewUpdateRequestMongo reviewUpdateRequestMongo) {
      //  RoomMongo roomMongo = roomMongoRepository.findById(roomMongoID)
        //        .orElseThrow(() -> new ResourceNotFoundException("Room with Id " + roomMongoID + " not found"));

        logger.info("Received request to add review. RoomMongoID: {}, CustomerMongoId: {}", roomid, customerid);

        String requestedRoomMongoID = reviewUpdateRequestMongo.getRoomid();
        Query query = new Query(Criteria.where("roomid").is(reviewUpdateRequestMongo.getRoomid()));
        logger.info("MongoDB Query: " + query.toString());
        logger.info("Received request with roomid: {}, customerid: {}", roomid, customerid);
        logger.info("Requested RoomMongoID from payload: {}", reviewUpdateRequestMongo.getRoomid());

        RoomMongo roomMongo = roomMongoRepository.findByRoomMongoID(reviewUpdateRequestMongo.getRoomid());

        if (roomMongo == null) {
            logger.error("Room not found for ID: {}", reviewUpdateRequestMongo.getRoomid());
            throw new ResourceNotFoundException("Room with ID " + reviewUpdateRequestMongo.getRoomid() + " not found");
        }

        //  CustomerMongo customerMongo = customerMongoRepository.findById(customerMongoId)
        //        .orElseThrow(() -> new ResourceNotFoundException("Customer with Id " + customerMongoId + " not found"));

        CustomerMongo customerMongo = customerMongoRepository.findByCustomerMongoId(reviewUpdateRequestMongo.getCustomerid());

        if (customerMongo == null) {
            throw new ResourceNotFoundException("Customer with ID " + reviewUpdateRequestMongo.getCustomerid() + " not found");
        }

        List<BookMongo> bookedRooms = bookMongoRepository.findRoomsByCustomerId(customerid);
        boolean isCustomerBookedRoom = bookedRooms.stream().anyMatch(book -> book.getRoomid().equals(roomid));
        if (!isCustomerBookedRoom) {
            throw new ResourceNotFoundException("Customer with Id " + customerid + " has not booked the room with Id " + roomid);
        }
       // customerMongo.setCustomerMongoId(customerMongo.getCustomerMongoId());
       // customerMongo.setFirstName(customerMongo.getFirstName());

        ReviewMongo reviewMongo = new ReviewMongo();
        reviewMongo.setReviewTxt(reviewUpdateRequestMongo.getReviewTxt());
        reviewMongo.setRoomid(roomMongo.getRoomid());
       // reviewMongo.setCustomerMongoId(customerMongoId);
        reviewMongo.setCustomerid(customerMongo.getCustomerid());
        reviewMongo.setDate(LocalDate.now());
       // reviewMongo.setReviewMongoId(reviewMongo.getReviewMongoId());

        return reviewMongoRepository.save(reviewMongo);
    }*/

    public ReviewMongo updateReview(ReviewUpdateRequestMongo reviewUpdateRequestMongo) {

        RoomMongo room = roomMongoRepository.findByRoomMongoID(reviewUpdateRequestMongo.getRoomMongoID());

        CustomerMongo customer = customerMongoRepository.findByCustomerMongoId(reviewUpdateRequestMongo.getCustomerMongoId());
        // Check if the customer with the given customerId has booked the room
      /*  List<BookMongo> bookedRooms = bookMongoRepository.findRoomsByCustomerId(customerid);
        boolean isCustomerBookedRoom = bookedRooms.stream().anyMatch(book -> book.getRoomid().equals(roomid));
        if (!isCustomerBookedRoom) {
            throw new ResourceNotFoundException("Customer with Id " + customerid + " not booked room with Id" + roomid);
        }*/
        ReviewMongo review = new ReviewMongo();
        review.setCustomerMongoId(customer.getCustomerMongoId());
        review.setRoomMongoID(room.getRoomMongoID());
        review.setDate(LocalDate.now());
        review.setReviewTxt(reviewUpdateRequestMongo.getReviewTxt());

        return reviewMongoRepository.save(review);

    }




      public List<ReviewMongo> findMostReviewedRooms(String firstName) {
       /* Aggregation aggregation = buildAggregation(firstName);
        AggregationResults<Object[]> results = mongoTemplate.aggregate(aggregation, "roomMongo", Object[].class);
        return results.getMappedResults();*/
        System.out.println("Find most reviewed rooms for first name: " + firstName);

        Aggregation aggregation = buildAggregation(firstName);
        System.out.println("Aggregation: " + aggregation.toString());

        AggregationResults<ReviewMongo> results = mongoTemplate.aggregate(aggregation, "roomMongo", ReviewMongo.class);
        List<ReviewMongo> mappedResults = results.getMappedResults();

        System.out.println("Result size: " + mappedResults.size());

        return mappedResults;

    }

    private Aggregation buildAggregation(String firstName) {
        AggregationOperation matchOperation = Aggregation.match(Criteria.where("customerMongo.firstName").is(firstName));

        AggregationOperation lookupOperation = Aggregation.lookup("reviewMongo", "roomMongoId", "roomMongoId", "reviews");

        AggregationOperation unwindOperation = Aggregation.unwind("reviews");

        AggregationOperation groupOperation = Aggregation.group("roomMongo.roomMongoId", "categoryMongo.categoryMongoId")
                .count().as("count_of_reviews");

        AggregationOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.DESC, "count_of_reviews"));

        return Aggregation.newAggregation(
                matchOperation,
                lookupOperation,
                unwindOperation,
                groupOperation,
                sortOperation
        );
    }

/*
    public List<Object[]> findMostReviewedRooms(String firstName) {

        return reviewMongoRepository.findMostReviewedRooms(firstName);
    }*/



    ///////////////////////////////////////////////////////////

    public ReviewMongo createReview(ReviewMongo reviewMongo) {
        return reviewMongoRepository.save(reviewMongo);
    }

    ///////////////////////////////////////////////////////////////////////////////
    public ResponseEntity<ReviewMongo> getReviewByTxt(String reviewTxt) {
            ReviewMongo review = reviewMongoRepository.findByReviewTxt(reviewTxt);
            if (review != null) {
                return ResponseEntity.ok(review);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


    ////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////
}

