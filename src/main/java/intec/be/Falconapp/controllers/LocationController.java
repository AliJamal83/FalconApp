package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.services.CountryService;
import intec.be.Falconapp.services.LocationService;
import intec.be.Falconapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/locations")
public class LocationController {


    @Autowired private LocationService locationService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;



    @GetMapping("/location")
    public String findAll(Model model) {
        List<State> stateList = stateService.findAll();
        List<Country> countryList = countryService.findAll();
        List<Location> locationList = locationService.findAll();

        model.addAttribute("countries", countryList);
        model.addAttribute("locations", locationList);
        model.addAttribute("states", stateList);
        return "Location";

    }


    // Add New Location
    @PostMapping("/locations/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return"redirect:/locations";

    }

    // Update Location
    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }


    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id) {
        return locationService.findById(id);

    }

    // Delete Location
    @RequestMapping(value = "/locations", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return"redirect:/location";
    }






}
