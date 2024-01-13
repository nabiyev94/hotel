package net.javaguides.springboot.backend.controller.mongoController;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Review;
import net.javaguides.springboot.backend.model.ReviewUpdateRequest;
import net.javaguides.springboot.backend.model.mongo.CustomerMongo;
import net.javaguides.springboot.backend.model.mongo.MostReviewedRoomDTO;
import net.javaguides.springboot.backend.model.mongo.ReviewMongo;
import net.javaguides.springboot.backend.model.mongo.ReviewUpdateRequestMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.ReviewMongoRepository;
import net.javaguides.springboot.backend.service.mongoService.ReviewMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;



@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReviewMongoController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewMongoController.class);


    @Autowired
    private ReviewMongoService reviewMongoService;

    @PostMapping("/review")
    public ReviewMongo createReview(@RequestBody ReviewMongo reviewMongo){
        return this.reviewMongoService.createReview(reviewMongo);
    }



/*
    @PutMapping("/{roomid}/customerMongo/{customerid}")
    @CrossOrigin(origins = "http://localhost:3000") // Hier die URL deiner React-Anwendung eintragen
    public ResponseEntity<ReviewMongo> addReview(
            @PathVariable String roomid,
            @PathVariable String customerid,
            @RequestBody ReviewUpdateRequestMongo reviewUpdateRequestMongo) {
        logger.info("Received request with roomid: {}, customerid: {}", roomid, customerid);

        // Validate that roomMongoID is not null or empty
        if (StringUtils.isEmpty(roomid)) {
            logger.error("roomid is null or empty in the request payload");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            ReviewMongo reviewMongo = reviewMongoService.addReview(roomid, customerid, reviewUpdateRequestMongo);
            return new ResponseEntity<>(reviewMongo, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            logger.error("Resource not found exception: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Internal server error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/



    @PutMapping("/addReview")
    @CrossOrigin(origins = "http://localhost:3000")
    public ReviewMongo updateReview( @RequestBody ReviewUpdateRequestMongo reviewUpdateRequestMongo) {
        return this.reviewMongoService.updateReview(reviewUpdateRequestMongo);
    }


//////////////////////////////////////////////////////////////////////////////////////////////// zum testen von Review

    @GetMapping("/{reviewTxt}")
    public ResponseEntity<ReviewMongo> getReviewByTxt(@PathVariable String reviewTxt) {
        return reviewMongoService.getReviewByTxt(reviewTxt);
    }
////////////////////////////////////////////////////////////////////////////////////////////////




/*
    @GetMapping("/mostReviews/{firstName}")
    public List<MostReviewsReport> getMostReviews(@PathVariable String firstName){
        return this.reviewMongoService.findMostReviews(firstName);
    }
*/
/*
    @GetMapping("/most-reviewed-rooms/{customerFirstName}")
    public ResponseEntity<Map<String, List<MostReviewedRoomDTO>>> getMostReviewedRoomsByCategory(
            @PathVariable String customerFirstName) {
        Map<String, List<MostReviewedRoomDTO>> result = reviewMongoService.getMostReviewedRoomsByCategory(customerFirstName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*/



      /*  List<Object> result = reviewMongoService.findMostReviewedRooms(firstName);

        if (result != null && !result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
      @GetMapping("/most-reviewed-rooms/{firstName}")
      public ResponseEntity<List<ReviewMongo>> getMostReviewedRooms(@PathVariable String firstName) {
          List<ReviewMongo> result = reviewMongoService.findMostReviewedRooms(firstName);
          if (result != null && !result.isEmpty()) {
              return new ResponseEntity<>(result, HttpStatus.OK);
          } else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

     /*   public ResponseEntity<List<ReviewMongoRepository.ReviewRoomSummary>> getMostReviewedRooms(@PathVariable String firstName)
        {
            List<ReviewMongoRepository.ReviewRoomSummary> result = reviewMongoService.findMostReviewedRooms(firstName);

            if (result != null && !result.isEmpty()) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }*/




    /////////////////////////////////////////////////


    ////////////////////////////////////////////////


}
