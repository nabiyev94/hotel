package net.javaguides.springboot.backend.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class DataMigratingController {

    @Autowired
    private DataMigrating dataMigrating;

    @GetMapping("/migrateData")
    public String migrateData(){
        this.dataMigrating.migrateData();
        return "Ok";
    }


    @DeleteMapping("/deleteMongoDb")
    public String deleteMongoDb(){
        this.dataMigrating.deleteData();
        return "Ok";
    }





}
