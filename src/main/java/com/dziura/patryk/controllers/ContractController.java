package com.dziura.patryk.controllers;

import com.dziura.patryk.model.Contract;
import com.dziura.patryk.repositories.ContractServiceImpl;
import com.dziura.patryk.repositories.SoftServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Controller class with mapping methods involve Contract
 */
@Controller
@RequestMapping
public class ContractController {
    /**
     * Instance of SoftServiceImpl which provide CRUD methods of Contract
     */
    private ContractServiceImpl contractServiceImpl;

    /**
     * Instance of SoftServiceImpl which provide CRUD methods of Soft
     */
    private SoftServiceImpl softServiceImpl;

    /**
     * Constructor that automatically initialize ContractService
     * @param contractServiceImpl is ContractServiceImpl's instance which is automatically created thanks to @Autowired annotation
     * @param softServiceImpl is SoftServiceImpl's instance which is automatically created thanks to @Autowired annotation
     */
    @Autowired
    public ContractController(ContractServiceImpl contractServiceImpl, SoftServiceImpl softServiceImpl){
        this.contractServiceImpl = contractServiceImpl;
        this.softServiceImpl = softServiceImpl;
    }

    /**
     * Method that specify starting view and pass to it List of all Contracts
     * @return ModelAndView object with view file's name and List of Contracts
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showAllContracts(){
        ModelAndView model = new ModelAndView("all_contracts");
        List<Contract> contracts = contractServiceImpl.getAllContracts();
        model.addObject("listContracts", contracts);
        return model;
    }

    /**
     * Method that specify view name and pass to it List of all active Contracts when specific URL is triggered
     * @return ModelAndView object with view file's name and List of Contracts
     */
    @RequestMapping(value = "/showActiveContracts", method = RequestMethod.GET)
    public ModelAndView showActiveContracts(){
        ModelAndView model = new ModelAndView("active_contracts");
        List<Contract> contracts = contractServiceImpl.getAllActiveContracts();
        model.addObject("listActiveContracts", contracts);
        return model;
    }

    /**
     * Method that specify html form view to add new Contract
     * @return ModelAndView object with view file's name
     */
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView model = new ModelAndView("contract_form");

        Contract contract = new Contract();
        model.addObject("contractForm", contract);
        return model;
    }

    /**
     * Method that is responsible for saving Contract created or updated by client
     * @param contract is a Contract object to save in database
     * @return ModelAndView object with specific URL that should be triggered after saving object in db
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("contractForm") Contract contract){
        contract.setSoft(softServiceImpl.findSoft(contract.getSoftId()));
        contractServiceImpl.saveContract(contract);

        if (contract.getStatus().equals("aktywna"))
            return new ModelAndView("redirect:/");
        else
            return new ModelAndView("redirect:/");
    }

    /**
     * Method that specify html form view to update Contract
     * @param id specify Contract which should be modified
     * @return ModelAndView object with view file's name
     */
    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView update(@PathVariable("id") long id){
        ModelAndView model = new ModelAndView("contract_form");

        Contract contract = contractServiceImpl.findContract(id);
        model.addObject("contractForm", contract);

        return model;
    }

    /**
     * Method that specify html form view to deactivate Contract
     * @param id specify Contract which should be deactivated
     * @return ModelAndView object with view file's name
     */
    @RequestMapping(value="/delete/{id}", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("id") long id){
        Contract contract = contractServiceImpl.findContract(id);
        if (contract.getStatus().equals("aktywna")) {
            contract.setStatus("nieaktywna");
            contractServiceImpl.saveContract(contract);
        }
        return new ModelAndView("redirect:/showActiveContracts");
    }

    /**
     * Method that is responsible for reading Contracts from .xlsx file
     * @return ModelAndView object with specific URL that should be triggered when all is done
     */
    @RequestMapping(value = "/readFile", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView read() {

        try {
            URL resource = this.getClass().getResource("/umowy_2016.xlsx");
            File file = null;
            try {
                file = new File(resource.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            int x = 0;
            Iterator<Cell> firstRowIterator = null;
            Row firstRow = null;

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (x == 0)
                    firstRow = currentRow;
                x++;

                firstRowIterator = firstRow.iterator();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Contract contract = new Contract();

                while (cellIterator.hasNext()) {
                    Cell currentColumn = firstRowIterator.next();
                    Cell currentCell = cellIterator.next();
                    if (x==1) {
                        contract = null;
                        continue;
                    }

                    switch (currentColumn.getStringCellValue()) {
                        case "system":
                            contract.setSoft(softServiceImpl.findSoftByName(currentCell.getStringCellValue()));
                            break;
                        case "order_number":
                            contract.setNumber(currentCell.getStringCellValue());
                            break;
                        case "from_date":
                            contract.setStartDate(currentCell.getStringCellValue());
                            break;
                        case "to_date":
                            contract.setEndDate(currentCell.getStringCellValue());
                            break;
                        case "amount":
                            contract.setIncomes(Double.valueOf(currentCell.getStringCellValue()));
                            break;
                        case "amount_period":
                            if (currentCell.getStringCellValue().equals("YEAR"))
                                contract.setScale("na rok");
                            else if (currentCell.getStringCellValue().equals("MONTH"))
                                contract.setScale("na miesiac");
                            break;
                        case "active":
                            if (currentCell.getStringCellValue().equals("true"))
                                contract.setStatus("aktywna");
                            else
                                contract.setStatus("nieaktywna");
                            break;

                        default:
                            break;
                    }
                }
                if (contract != null)
                    contractServiceImpl.saveContract(contract);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/");
    }
}
