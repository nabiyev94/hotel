package com.imse.hotel.sql.service;


import com.imse.hotel.sql.model.Category;
import com.imse.hotel.sql.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        return this.categoryRepository.save(category);
    }
}
