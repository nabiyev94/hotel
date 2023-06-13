package com.imse.hotel.nosql.servicesmongo;

import com.imse.hotel.nosql.modelmongodb.CategoryMongoDb;
import com.imse.hotel.nosql.repositorymongodb.CategoryMongoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMongoService {

    @Autowired
    private CategoryMongoDbRepository categoryMongoDbRepository;


    public CategoryMongoDb addCategory(CategoryMongoDb categoryMongoDb){
        return this.categoryMongoDbRepository.save(categoryMongoDb);
    }
}
