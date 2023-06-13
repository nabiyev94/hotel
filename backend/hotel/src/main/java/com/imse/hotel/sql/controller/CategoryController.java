package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.Category;
import com.imse.hotel.sql.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return this.categoryService.addCategory(category);
    }


}
