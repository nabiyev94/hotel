package net.javaguides.springboot.backend.service;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.repository.CustomerRepository;
import net.javaguides.springboot.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }


    public ResponseEntity<Customer> getCustomerById( int customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(( ) -> new ResourceNotFoundException("customer not exist with id :" + customerId));

        return ResponseEntity.ok(customer);
    }


    }
