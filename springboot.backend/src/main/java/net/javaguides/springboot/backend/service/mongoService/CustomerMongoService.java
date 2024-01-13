package net.javaguides.springboot.backend.service.mongoService;

import net.javaguides.springboot.backend.model.mongo.CustomerMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMongoService {

    @Autowired
    private CustomerMongoRepository customerMongoRepository;
    public List<CustomerMongo> getAllCustomer() {
        return customerMongoRepository.findAll();
    }

    public CustomerMongo createCustomer(CustomerMongo customer) {
        return customerMongoRepository.save(customer);
    }
}
