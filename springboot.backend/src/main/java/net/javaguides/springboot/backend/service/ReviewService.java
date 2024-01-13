package net.javaguides.springboot.backend.service;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.*;
import net.javaguides.springboot.backend.repository.BookRepository;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.ReviewRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();

    }


////////////////////////////////////////////////////////////////////////// reviewRoom******************
    public Review writeReview( long roomId, String email, ReviewUpdateRequest requestBody) {

            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new ResourceNotFoundException("Room with Id" + roomId + " not found"));
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers.isEmpty()) {
            throw new ResourceNotFoundException("Customer with email " + email + " not found");
        }
        Customer customer = customers.get(0);

            List<Object[]> bookedRooms = bookRepository.findAllRooms(email);
            boolean isCustomerBookedRoom = bookedRooms.stream().anyMatch(row -> Long.parseLong(row[1].toString()) == roomId);
            if (!isCustomerBookedRoom) {
                throw new ResourceNotFoundException("Customer with email " + email + " not booked room with Id" + roomId);
            }
        Review review = new Review();
        review.setCustomer(customer);
        review.setRoom(room);
        review.setDate(LocalDate.now());
        review.setReviewTxt(requestBody.getReviewTxt());

        roomRepository.save(room);
        customerRepository.save(customer);

        return reviewRepository.save(review);
    }

    public List<Object[]> getNumberOfReviewsByCustomerFirstName(String firstName) {
        return reviewRepository.findReviewsByCustomerFirstName(firstName);
    }


/*
    public ResponseEntity<Review> getReviewById( long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review not exist with id:" + reviewId));
        return ResponseEntity.ok(review);
    }

*/
}
