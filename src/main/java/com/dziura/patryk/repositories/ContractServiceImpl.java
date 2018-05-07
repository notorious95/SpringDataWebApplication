package com.dziura.patryk.repositories;

import com.dziura.patryk.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that is a Service of Contract
 * This class calls CRUD methods using ContractService interface
 */
@Service
public class ContractServiceImpl {
    /**
     * Instance of ContractService which specify CRUD method that should be used
     */
    private ContractService contractService;

    /**
     * Constructor that automatically initialize ContractService
     * @param contractService is ContractService's instance which is automatically created thanks to @Autowired annotation
     */
    @Autowired
    public void setContractService(ContractService contractService){
        this.contractService = contractService;
    }

    /**
     * Method that find all Contracts using ContractService
     * @return List of all Contracts from database
     */
    public List<Contract> getAllContracts(){
        return contractService.findAll();
    }

    /**
     * Method that find all Contracts which have specific Status
     * @return List of all active Contracts from database
     */
    public List<Contract> getAllActiveContracts(){
        return contractService.findContractsByStatusEquals("aktywna");
    }

    /**
     * Method that is responsible for saving given Contract to database
     * @param contract is a Contract object to save in database
     */
    public void saveContract(Contract contract){
        contractService.save(contract);
    }

    /**
     * Method that is responsible for finding Contract based on given id
     * @param id is a Contract's id
     * @return single Contract object
     */
    public Contract findContract(long id){
        return contractService.findContractsById(id);
    }
}
