package net.javaguides.springboot.backend.service.mongoService;

import net.javaguides.springboot.backend.model.Book;
import net.javaguides.springboot.backend.model.mongo.BookMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.BookMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMongoService {

    @Autowired
    private BookMongoRepository bookMongoRepository;

    public List<BookMongo> getAllBooks() {
        return bookMongoRepository.findAll();
    }

    public BookMongo createBook(BookMongo book) {

            return bookMongoRepository.save(book);
    }

    public List<BookMongo> findRoomsByCustomerId(String customerMongoId) {
        return bookMongoRepository.findRoomsByCustomerId(customerMongoId);
    }


}
