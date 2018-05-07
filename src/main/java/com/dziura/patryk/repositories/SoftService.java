package com.dziura.patryk.repositories;

import com.dziura.patryk.model.Soft;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface that specify Soft's CRUD methods
 */
public interface SoftService extends CrudRepository<Soft, Long> {
    /**
     * Method that find all Softs from database
     * @return List with Softs
     */
    @Override
    List<Soft> findAll();

    /**
     * Method that find single Soft by id
     * @param id specify Soft's id
     * @return single Soft object
     */
    Soft findSoftById(long id);

    /**
     * Method that find Soft based on given name
     * @param name specify Soft's name
     * @return single Soft object
     */
    Soft findSoftByNameEquals(String name);
}
