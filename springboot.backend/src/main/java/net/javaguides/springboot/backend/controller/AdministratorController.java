package net.javaguides.springboot.backend.controller;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.repository.AdministratorRepository;
import net.javaguides.springboot.backend.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {

        @Autowired
        private AdministratorService administratorService;


        @GetMapping
        public List<Administrator> getAllAdministrator( ){
            return this.administratorService.getAllAdministrator();
        }

    }


