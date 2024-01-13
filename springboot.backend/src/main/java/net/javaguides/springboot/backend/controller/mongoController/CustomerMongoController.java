package net.javaguides.springboot.backend.controller.mongoController;

import net.javaguides.springboot.backend.model.Customer;
import net.javaguides.springboot.backend.model.mongo.CustomerMongo;
import net.javaguides.springboot.backend.service.mongoService.CustomerMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CustomerMongoController {
    @Autowired
    private CustomerMongoService customerMongoService;

    @GetMapping("/customer")
    public List<CustomerMongo> getAllCustomer( ){
        return this.customerMongoService.getAllCustomer();
    }


    @PostMapping("/customer")
    public CustomerMongo createCustomer(@RequestBody CustomerMongo customer){
        return this.customerMongoService.createCustomer(customer);
    }
}
