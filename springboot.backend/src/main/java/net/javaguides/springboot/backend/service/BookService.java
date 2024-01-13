package net.javaguides.springboot.backend.service;

import net.javaguides.springboot.backend.exception.BookingException;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.*;
import net.javaguides.springboot.backend.repository.BookRepository;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private RoomService roomService;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book createBook(Book book) {

        return bookRepository.save(book);
    }


////////////////////////////////////////////////////// zum testen das script in BookRepository
    public List<Object[]> findAllRoomsForCustomer(String email) {
        return bookRepository.findAllRooms(email);
    }

    public ResponseEntity<Book> getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not exist with id:" + id));
        return ResponseEntity.ok(book);

    }



    public Book updateBook(long bookingId, long roomId, Integer customerId) {
        Book book = bookRepository.findById(bookingId).get();
        Room room = roomRepository.findById(roomId).get();
        Customer customer = customerRepository.findById(customerId).get();
        book.setRoom(room);
        book.setCustomer(customer);
        return bookRepository.save(book);
    }

// For Main use case

   public List<Book> reserveRoom(int numberOfDesiredRooms, BookRequest requestBody) {

         Customer customer;
         if (roomService.areRoomsAvailable( requestBody.getCheckInDate(),
                 requestBody.getCheckOutDate(),
                 requestBody.getCategoryId(),
                 requestBody.getNumberOfRooms()
         )) {

            // Create and save booking records
            List<Room> bookedRooms = roomRepository.findAvailableRooms(
                     requestBody.getCheckInDate(),
                     requestBody.getCheckOutDate(),
                     requestBody.getCategoryId()
            );

            List<Book> bookings = new ArrayList<>();

             List<Customer> customers = customerRepository.findByEmail(requestBody.getEmail());
             if (customers.isEmpty()) {
                 throw new ResourceNotFoundException("Customer with Email: " + requestBody.getEmail() + " not found");
             }
             customer = customers.get(0);

             Random random = new Random();

             for (int i = random.nextInt(bookedRooms.size()); i < bookedRooms.size(); i++)
             {
                Book booking = new Book( requestBody.getCheckInDate(),  requestBody.getCheckOutDate(), bookedRooms.get(i), customer);
                 bookings.add(booking);
                 numberOfDesiredRooms--;
                 if(numberOfDesiredRooms == 0)
                     break;
            }
           return  bookRepository.saveAll(bookings);
        } else {
            throw new BookingException("No available rooms for the selected dates and categoryId.");
        }
    }



    public ResponseEntity<HttpStatus> deleteBook(long bookingId) {
        Book book = bookRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException(" Book not exist with id:" + bookingId));
        bookRepository.delete(book);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

