package com.dziura.patryk.repositories;

import com.dziura.patryk.model.Soft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that is a Service of Soft
 * This class calls CRUD methods using SoftService interface
 */
@Service
public class SoftServiceImpl {
    /**
     * Instance of SoftService which specify CRUD method that should be used
     */
    private SoftService softService;

    /**
     * Constructor that automatically initialize SoftService
     * @param softService is SoftService's instance which is automatically created thanks to @Autowired annotation
     */
    @Autowired
    public void setSoftService(SoftService softService){
        this.softService = softService;
    }

    /**
     * Method that find all Softs in database using SoftService
     * @return List of all found Softs
     */
    public List<Soft> getAllSofts(){
        return softService.findAll();
    }

    /**
     * Method that find specific Soft based on given id
     * @param id is a Soft's id
     * @return single Soft object
     */
    public Soft findSoft(long id){
        return softService.findSoftById(id);
    }

    /**
     * Method that is responsible for finding Soft based on given name
     * @param name is a Soft's name
     * @return single Soft object
     */
    public Soft findSoftByName(String name){
        return softService.findSoftByNameEquals(name);
    }
}
