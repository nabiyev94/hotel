package net.javaguides.springboot.backend.service.mongoService;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.mongo.CategoryMongo;
import net.javaguides.springboot.backend.repository.mongoRepository.CategoryMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMongoService {

    @Autowired
    private CategoryMongoRepository categoryMongoRepository;

    public ResponseEntity<?> getAllCat() {
        List<CategoryMongo> categoryMongoList = categoryMongoRepository.findAll();
        if (categoryMongoList.size() > 0) {
            return new ResponseEntity<List<CategoryMongo>>(categoryMongoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No categoryMongoList available", HttpStatus.NOT_FOUND);
        }
    }

    public CategoryMongo createCategory(CategoryMongo categoryMongo) {
        return categoryMongoRepository.save(categoryMongo);
    }

    public ResponseEntity<CategoryMongo> updateCat(String id, CategoryMongo categoryMongo) {
        CategoryMongo updateCategory = categoryMongoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category not exist with id :" + id));
        updateCategory.setName(categoryMongo.getName());
        updateCategory.setDescription(categoryMongo.getDescription());
        updateCategory.setCapacity(categoryMongo.getCapacity());
        categoryMongoRepository.save(updateCategory);
        return ResponseEntity.ok(updateCategory);

    }
}
