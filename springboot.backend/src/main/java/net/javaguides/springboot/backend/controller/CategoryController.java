package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.model.Category;
import net.javaguides.springboot.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        @GetMapping
        public List<Category> getAllCategory( ){
             return this.categoryService.getAllCategory();

        }

    }




