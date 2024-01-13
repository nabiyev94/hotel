package net.javaguides.springboot.backend.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FillDatabaseController {
    @Autowired
    private FillDatabase fillDatabase;

    @GetMapping("/fillTest")
    public String fillTesting(){
        this.fillDatabase.fillDatabaseTable();
        return "Ok";
    }

    @GetMapping("/deleteDataBase")
    public String deleteDataBase(){
        this.fillDatabase.deleteAllData();
        return "Ok";
    }


}


