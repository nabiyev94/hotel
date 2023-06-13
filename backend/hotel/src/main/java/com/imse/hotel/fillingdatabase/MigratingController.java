package com.imse.hotel.fillingdatabase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MigratingController {

    @Autowired
    private DataMigrating dataMigrating;

    @GetMapping("/migrateData")
    public String migrateData(){
        this.dataMigrating.migrateData();
        return "Okkkkkk";
    }

    @DeleteMapping("/deleteMongoDb")
    public String deleteMongoDb(){
        this.dataMigrating.deleteData();
        return "Okkkkkk";
    }





}
