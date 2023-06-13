package com.imse.hotel.nosql.servicesmongo;

import com.imse.hotel.nosql.modelmongodb.CustomerMongoDb;
import com.imse.hotel.nosql.repositorymongodb.CustomerMongoDbRepository;
import com.imse.hotel.sql.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerMongoServie {

    @Autowired
    private CustomerMongoDbRepository customerMongoDbRepository;


    public CustomerMongoDb saveCustomer(CustomerMongoDb customer){
        return this.customerMongoDbRepository.save(customer);
    }

}
