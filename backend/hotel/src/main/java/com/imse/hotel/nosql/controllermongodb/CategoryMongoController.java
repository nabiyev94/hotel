package com.imse.hotel.nosql.controllermongodb;

import com.imse.hotel.nosql.modelmongodb.CategoryMongoDb;
import com.imse.hotel.nosql.servicesmongo.CategoryMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryMongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CategoryMongoService categoryMongoService;

    @PostMapping("/addCategoryToDb")
    public CategoryMongoDb addCategoryToDb(@RequestBody CategoryMongoDb categoryMongoDb){
        return this.categoryMongoService.addCategory(categoryMongoDb);

    }
}
