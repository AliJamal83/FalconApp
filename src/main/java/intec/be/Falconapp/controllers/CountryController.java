package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    // this function will refresh the page and update it when we add new country.js to the list, it will return updated list of countries.
    // it will take the country.js from the add form and will redirect it to the list of the countries.
    @PostMapping("/countries/addNewCountry")
    public String addNewCountry(Country country) {
        countryService.save(country);

        //Will redirect to the same page of the updated list of countries
        return "redirect:/countries";
    }

    // Function for displaying the content of the model pop up
    @RequestMapping("countries/findById")
    // It will not return as JSON or redirect to page that we will display a JSON. but it will return it on the pop-up
    @ResponseBody
    public Optional<Country> findById(Integer id) {

        // Will return the same content of the model pop up
        return countryService.findById(id);

    }


    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";

    }
}
