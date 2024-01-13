package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import net.javaguides.springboot.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomer( ){
        return this.customerService.getAllCustomer();
    }

    //////////////////////////////////////////////////// für Review
    @GetMapping("{customerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Customer> getCustomerById( @PathVariable int customerId){
        return this.customerService.getCustomerById(customerId);

    }


}
