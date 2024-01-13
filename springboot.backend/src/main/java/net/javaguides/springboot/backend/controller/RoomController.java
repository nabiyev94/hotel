package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.model.Category;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.model.Room;
import net.javaguides.springboot.backend.repository.AdministratorRepository;
import net.javaguides.springboot.backend.repository.CategoryRepository;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import net.javaguides.springboot.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Comparator;
import java.util.List;

// Building GET All Rooms // Rest API => das wird in controller
@RestController
@RequestMapping("/rooms") // this api return a list of Rooms to the client=> with help  @GetMapping and Method getAllRooms()
public class RoomController {  // controller is HTTP Request

    @Autowired
    private RoomService roomService;


    @GetMapping
    public List<Room> getAllRooms(){

        return this.roomService.getAllRooms();
    }


}



