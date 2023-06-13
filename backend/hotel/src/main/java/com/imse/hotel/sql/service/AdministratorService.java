package com.imse.hotel.sql.service;

import com.imse.hotel.sql.model.Administrator;
import com.imse.hotel.sql.repository.AdminstratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

    @Autowired
    private AdminstratorRepository adminstratorRepository;


    public Administrator addAdmin(Administrator administrator){
        //this.adminstratorRepository.save(administrator.getChef());
        //administrator.getChef().setAdminId(administrator.getChef().getAdminId());
        return this.adminstratorRepository.save(administrator);


    }
}
