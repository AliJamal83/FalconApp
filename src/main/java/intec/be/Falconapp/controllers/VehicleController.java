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
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;


    //Get All Vehicles
    @GetMapping("vehicles")
    public String findAll(Model model) {

        List<Vehicle> listOfVehicles = vehicleService.getVehicles();
        List<VehicleType> listOfVehicleTypes = vehicleTypeService.findAll();
        List<VehicleModel> listOfVehicleModel = vehicleModelService.findAll();
        List<VehicleMake> listOfVehicleMakes = vehicleMakeService.findAll();
        List<Location> listOfLocations = locationService.getLocations();
        List<Employee> listOfEmployees = employeeService.findAll();



        model.addAttribute("vehicles", vehicleService.getVehicles());

        model.addAttribute("vehicleModels", vehicleModelService.findAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.findAll());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("employees", employeeService.findAll());

        return "Vehicle";
    }


    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id) {
        return vehicleService.findById(id);
    }


    //Add Vehicle
    @PostMapping(value = "vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }


    @RequestMapping(value = "vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }


    @RequestMapping(value = "vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }


}
