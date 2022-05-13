package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.*;
import intec.be.Falconapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StateService stateService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private CountryService countryService;


    //Get All Employees
    @GetMapping("employees")
    public String findAll(Model model) {

        List<Country> listOfCountries = countryService.findAll();
        List<State> listOfStates = stateService.findAll();
        List<Employee> listOfEmployees = employeeService.findAll();
        List<JobTitle> listOfJobTitle = jobTitleService.findAll();
        List<EmployeeType> listOfEmployeesType = employeeTypeService.findAll();

        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("jobTitles", jobTitleService.findAll());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return "Employee";

    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }


    //Add New Employee
    @PostMapping(value="employees/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }


    @RequestMapping(value="employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
