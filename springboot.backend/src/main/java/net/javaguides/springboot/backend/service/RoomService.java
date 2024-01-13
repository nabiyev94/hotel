package net.javaguides.springboot.backend.service;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.model.Category;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;


    public List<Room> getAllRooms() {
        return roomRepository.findAll();

    }
    public boolean areRoomsAvailable(LocalDate checkInDate, LocalDate checkOutDate, int categoryId, int numberOfRooms
                                      ) {
        List<Room> availableRooms = roomRepository.findAvailableRooms(checkInDate, checkOutDate, categoryId
                );
        return availableRooms.size() >= numberOfRooms;
    }
}





