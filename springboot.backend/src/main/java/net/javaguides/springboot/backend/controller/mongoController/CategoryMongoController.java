package net.javaguides.springboot.backend.controller.mongoController;

import net.javaguides.springboot.backend.model.mongo.CategoryMongo;
import net.javaguides.springboot.backend.service.mongoService.CategoryMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoryMongoController {

    @Autowired
    private CategoryMongoService categoryMongoService;

    @GetMapping("/cat")
    public ResponseEntity<?> getAllCat(){
        return this.categoryMongoService.getAllCat();

    }



    @PostMapping("/cat")
    public CategoryMongo createCategory(@RequestBody CategoryMongo categoryMongo){
        return this.categoryMongoService.createCategory(categoryMongo);
    }

    @PutMapping("/cat/{id}")
    public ResponseEntity<CategoryMongo> updateCat(@PathVariable String id, @RequestBody CategoryMongo categoryMongo){
        return this.categoryMongoService.updateCat(id, categoryMongo);
    }

}
