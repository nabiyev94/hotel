package com.imse.hotel.fillingdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping(path = "/fillingdatabase")
public class DataBaseFillingController {

    @Autowired
    private FillingDataBase fillingDataBase;


    @GetMapping("/fillTesting")
    public String fillTesting(){
        this.fillingDataBase.fillDataBaseTables();
        return "Okkkkkk";
    }

    @GetMapping("/deleteDataBase")
    public String deleteDataBase(){
        this.fillingDataBase.deleteAllData();
        return "Okkkkkk";
    }



}
