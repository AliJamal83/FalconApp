package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.services.CountryService;
import intec.be.Falconapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {


    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;


    // Get All States
    @GetMapping("states")
    public String findAll(Model model) {
       model.addAttribute("states", stateService.findAll());
       model.addAttribute("countries", countryService.findAll());
       return "state";
    }


    //Add State
    @PostMapping("/state/addNewState")
    public String addNewState(State state) {
        stateService.save(state);
        return "redirect:/states";
    }


    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(Integer id) {
        return stateService.findById(id);
    }


    @RequestMapping(value = "/states/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }


    @RequestMapping(value = "/states/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        stateService.delete(id);
        return "redirect:/states";
    }
}
