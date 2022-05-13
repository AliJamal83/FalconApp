package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.EmployeeType;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.services.EmployeeTypeService;
import intec.be.Falconapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;


    @GetMapping("/employeesTypes")
    public String findAll(Model model) {
        List<EmployeeType> listOfEmployeeTypes = employeeTypeService.findAll();
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return "EmployeeType";

    }


    // Add New employee type
    @PostMapping("/employeesType/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/EmployeesTypes";

    }

    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeService.findById(id);

    }


    // Update Location
    @RequestMapping(value = "/employeesTypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeesType";
    }


    // Delete Location
    @RequestMapping(value = "/employeesTypes", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employeesType";
    }
}
