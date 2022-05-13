package intec.be.Falconapp.controllers;

import com.sun.xml.bind.v2.runtime.unmarshaller.UnmarshallingContext;
import intec.be.Falconapp.models.Client;
import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.services.ClientService;
import intec.be.Falconapp.services.CountryService;
import intec.be.Falconapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {


    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ClientService clientService;


    //Get all Clients
    @GetMapping("/clients")
    public String findAll(Model model) {
        List<Country> listOfCountries = countryService.findAll();
        List<State> listOfStates = stateService.findAll();
        List<Client> listOfClients = clientService.findAll();

        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "client";
    }


    @RequestMapping("/clients/findById")
    @ResponseBody
    public Optional <Client> findById(Integer id) {
        return clientService.findById(id);

    }


    //Add New Client
    @PostMapping(value = "clients/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }


    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }


    @RequestMapping(value = "/clients/update", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/clients";

    }
}
