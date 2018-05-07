package com.dziura.patryk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller class with mapping methods that don't involve Contract and Soft
 */
@Controller
@RequestMapping
public class AppController {

    /**
     * Method that calls view with general information about application when specific URL is triggered
     * @return ModelAndView object with view file's name
     */
    @RequestMapping(value = "/informations", method = RequestMethod.GET)
    public ModelAndView information() {
        ModelAndView model = new ModelAndView("info");
        return model;
    }
}
