package com.dziura.patryk.controllers;

import com.dziura.patryk.model.Soft;
import com.dziura.patryk.repositories.SoftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Controller class with mapping methods involve Soft
 */
@Controller
public class SoftController {
    /**
     * Instance of SoftServiceImpl which provide CRUD methods
     */
    private SoftServiceImpl softServiceImpl;

    /**
     * Constructor that automatically initialize ContractService
     * @param softServiceImpl is SoftServiceImpl's instance which is automatically created thanks to @Autowired annotation
     */
    @Autowired
    public SoftController(SoftServiceImpl softServiceImpl){
        this.softServiceImpl = softServiceImpl;
    }

    /**
     * Method that specify view name and pass to it List of all Softs when specific URL is triggered
     * @return ModelAndView object with view file's name and List of Softs
     */
    @RequestMapping(value = "/showSofts", method = RequestMethod.GET)
    public ModelAndView showAllSofts(){
        ModelAndView model = new ModelAndView("soft");
        List<Soft> softs = softServiceImpl.getAllSofts();
        model.addObject("listAllSofts", softs);
        return model;
    }
}
