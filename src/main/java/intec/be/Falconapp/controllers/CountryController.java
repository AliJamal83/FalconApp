package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {


    //Autowired the service into the controller
    @Autowired
    private CountryService countryService;

    //To pass the list of the countries to the html we need to put a Model object as a parameter to this method.
    //after that we have to place the countryList into this Model.
    @GetMapping("/countries")
    public String getCountries(Model model) {

        //List of countries will return all the list of the countries
        List<Country> countryList = countryService.getCountries();

        // Add the countries attribute countries (countryList) to the model.
        model.addAttribute("countries", countryList);
        return "Country";

    }
}
