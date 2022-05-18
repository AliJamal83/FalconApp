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

    @Autowired	private SupplierService supplierService;
    @Autowired	private CountryService countryService;
    @Autowired	private StateService stateService;


    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getSuppliers());

        model.addAttribute("countries", countryService.findAll());

        model.addAttribute("states", stateService.findAll());


        return "Supplier";
    }

    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id) {
        return supplierService.findById(id);
    }

    @RequestMapping(value="/suppliers/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="/suppliers/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }


}
