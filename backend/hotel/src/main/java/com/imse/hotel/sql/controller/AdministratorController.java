package com.imse.hotel.sql.controller;

import com.imse.hotel.sql.model.Administrator;
import com.imse.hotel.sql.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;


    @PostMapping("/addAdministrator")
    public Administrator addAdministrator(@RequestBody Administrator administrator){
        return this.administratorService.addAdmin(administrator);
    }
}
