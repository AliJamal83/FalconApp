package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Supplier;
import intec.be.Falconapp.services.CountryService;
import intec.be.Falconapp.services.StateService;
import intec.be.Falconapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private SupplierService supplierService;


    //Get All Suppliers
    @GetMapping("suppliers")
    public String findAll(Model model){
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "Supplier";
    }


    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id)
    {
        return supplierService.findById(id);
    }


    //Add Supplier
    @PostMapping(value="suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }


    @RequestMapping(value="suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }


    @RequestMapping(value="suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }


}
