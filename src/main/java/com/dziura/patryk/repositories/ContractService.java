package com.dziura.patryk.repositories;

import com.dziura.patryk.model.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interface that specify Contract's CRUD methods
 */
public interface ContractService extends CrudRepository<Contract, Long> {
    /**
     * Method that find all Contracts from database
     * @return List with Contracts
     */
    @Override
    List<Contract> findAll();

    /**
     * Method that find all Contracts with specific status
     * @param status specify Contract's status
     * @return List with Contracts
     */
    List<Contract> findContractsByStatusEquals(String status);

    /**
     * Method that find single Contract by id
     * @param id specify Contract's id
     * @return single Contract
     */
    Contract findContractsById(long id);

    /**
     * Method responsible for saving given Contract to database
     * @param contract is a Contract to save
     * @return saved Contract
     */
    @Override
    Contract save(Contract contract);
}
