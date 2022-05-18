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

    @Autowired  private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String getEmployeeTypes(Model model) {

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

        model.addAttribute("employeeTypes", employeeTypeList);
        return "employeeType";
    }

    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping("employeeTypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id) {
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value="/employeeTypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value="/employeeTypes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
