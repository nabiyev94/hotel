package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.*;
import net.javaguides.springboot.backend.repository.*;
import net.javaguides.springboot.backend.service.BookService;
import net.javaguides.springboot.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

        @Autowired
        private ReviewService reviewService;

        @Autowired
        private BookService bookService;

        @GetMapping
        public List<Review> getAllReviews(){
            return this.reviewService.getAllReviews();

        }


     @PutMapping("/{roomId}/customer/{email}")
     @CrossOrigin(origins = "http://localhost:3000")
    public Review writeReview( @PathVariable Long roomId, @PathVariable String email, @RequestBody ReviewUpdateRequest requestBody) {
         return this.reviewService.writeReview(roomId, email, requestBody);
    }





    @GetMapping("/reviews-by-customer/{firstName}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Object[]> getNumberOfReviewsByCustomerFirstName(@PathVariable String firstName) {
        return this.reviewService.getNumberOfReviewsByCustomerFirstName(firstName);
    }



    // build get room by id REST API
    /*    @GetMapping("{reviewId}")
        public ResponseEntity<Review> getReviewById(@PathVariable long reviewId){
            return this.reviewService.getReviewById(reviewId);
        } */

}
