package net.javaguides.springboot.backend.controller.mongoController;

import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.springboot.backend.model.Administrator;
import net.javaguides.springboot.backend.model.mongo.AdministratorMongo;
import net.javaguides.springboot.backend.service.mongoService.AdministratorMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AdministratorMongoController {
    @Autowired
    private AdministratorMongoService administratorMongoService;


}
