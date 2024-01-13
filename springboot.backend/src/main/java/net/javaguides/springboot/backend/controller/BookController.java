package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.model.Book;
import net.javaguides.springboot.backend.model.BookRequest;
import net.javaguides.springboot.backend.model.ReviewUpdateRequest;
import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.service.BookService;
import net.javaguides.springboot.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@RestController
@RequestMapping("/bookDesiredRooms")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> getAllBooks( ) {
        return this.bookService.getAllBooks();

    }

    ///////////////////////////////////////////////////////// zum testen das script in BookRepository(BookedList)
    @GetMapping("/customer/{email}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Object[]>> getAllRoomsForCustomer(@PathVariable String email) {
        List<Object[]> rooms = bookService.findAllRoomsForCustomer(email);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    ////////////////////////////////////////////////////////


    //
    @PostMapping
    public Book createBookToDB(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }


    @GetMapping("{id}")
    public ResponseEntity<Book> getRoomById(@PathVariable long id) {
        return this.bookService.getBookById(id);
    }

    @PutMapping("/{bookingId}/room/{roomId}/customer/{customerId}")
    Book updateBook(@PathVariable long bookingId, @PathVariable long roomId, @PathVariable int customerId) {
        return this.bookService.updateBook(bookingId, roomId, customerId);
    }




// Main Use Case
    @PutMapping("{numberOfDesiredRooms}")
    List<Book> reserveRoom(//@PathVariable long roomId,
                           @PathVariable int numberOfDesiredRooms, @RequestBody BookRequest requestBody) {
       return this.bookService.reserveRoom(//roomId,
               numberOfDesiredRooms, requestBody);
    }





    @DeleteMapping("{bookingId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable long bookingId){
        return this.bookService.deleteBook(bookingId);
    }





//

}
