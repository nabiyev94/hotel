package com.imse.hotel.nosql.controllermongodb;


import com.imse.hotel.nosql.modelmongodb.CustomerMongoDb;
import com.imse.hotel.nosql.servicesmongo.CustomerMongoServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerMongoController {

    @Autowired
    private CustomerMongoServie customerMongoServie;



    @PostMapping("/addCustomerToDb")
    public CustomerMongoDb addCustomerToDb(@RequestBody CustomerMongoDb customer){
        return this.customerMongoServie.saveCustomer(customer);
    }
}
