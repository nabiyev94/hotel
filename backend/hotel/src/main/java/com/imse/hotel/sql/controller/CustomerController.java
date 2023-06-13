package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.Customer;
import com.imse.hotel.sql.model.Room;
import com.imse.hotel.sql.model.RoomReviewing;
import com.imse.hotel.sql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/registCustomer")
    public Customer registCustomer(@RequestBody Customer customer) throws Exception {
        return this.customerService.registCustomer(customer);
    }

    @GetMapping("/getListOfCustomers")
    public List<Customer> getListOfCustomers() {
        return this.customerService.getAllCustomers();
    }




/*
    @GetMapping("/customer/{emailAdress}")
    public Customer loginCustomer(@PathVariable String emailAdress) throws Exception {
        return this.customerService.findCustomerByEmailAdress(emailAdress);
    }*/

    @DeleteMapping("/customer/{customerID}")
    public String deleteCustomer(@PathVariable int customerID){
        this.customerService.deleteCustomerFromDb(customerID);
        return "Okkk";
    }


    @GetMapping("/customer/{customerID}")
    public List<Room> getReviewListCustomer(@PathVariable int customerID) {
        return this.customerService.getList(customerID);
    }


}