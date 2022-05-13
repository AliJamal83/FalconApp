package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Client;
import intec.be.Falconapp.models.Contact;
import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.services.ContactService;
import intec.be.Falconapp.services.CountryService;
import intec.be.Falconapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {


    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ContactService contactService;


    //Get All Contacts
    @GetMapping("/contacts")
    public String findAll(Model model) {

        List<Country> listOfCountries = countryService.findAll();
        List<State> listOfStates = stateService.findAll();
        List<Contact> listOfContacts = contactService.findAll();

        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("contacts", contactService.findAll());
        return "Contact";

    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id) {
        return contactService.findById(id);
    }


    //Add contacts
    @PostMapping(value="contacts/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }


    @RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";

    }


    @RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }


}
