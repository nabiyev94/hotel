package net.javaguides.springboot.backend.service.mongoService;

import net.javaguides.springboot.backend.model.mongo.AdministratorMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.AdministratorMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class AdministratorMongoService {


    @Autowired
    private AdministratorMongoRepository administratorMongoRepository;
    public List<AdministratorMongo> getAllAdministrator() {
        return administratorMongoRepository.findAll();
    }
}
