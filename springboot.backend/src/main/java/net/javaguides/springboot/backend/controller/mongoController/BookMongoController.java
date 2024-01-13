package net.javaguides.springboot.backend.controller.mongoController;

import net.javaguides.springboot.backend.model.Book;
import net.javaguides.springboot.backend.model.mongo.BookMongo;
import net.javaguides.springboot.backend.service.mongoService.BookMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookMongoController {
    @Autowired
    private BookMongoService bookMongoService;

    @GetMapping("/book")
    public List<BookMongo> getAllBooks( ) {
        return this.bookMongoService.getAllBooks();

    }

    @PostMapping("/book")
    public BookMongo createBookToDB(@RequestBody BookMongo book) {
        return this.bookMongoService.createBook(book);
    }

    /////////////////////////////////////// testen von report

    @GetMapping("/findRoomsByCustomerId/{customerMongoId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<BookMongo> findRoomsByCustomerId(@PathVariable String customerMongoId) {
        return bookMongoService.findRoomsByCustomerId(customerMongoId);
    }
}
