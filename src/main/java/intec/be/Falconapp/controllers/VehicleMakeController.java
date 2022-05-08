package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.VehicleMake;
import intec.be.Falconapp.services.VehicleMakeService;
import intec.be.Falconapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMakeController {


    @Autowired
    private VehicleMakeService vehicleMakeService;

    //Get All Vehicle Makes
    @GetMapping("/vehicleMakes")
    public String findAll(Model model) {
        model.addAttribute("vehicleMakes", vehicleMakeService.getAllVehicleMakes());
        return "VehicleMake";

    }


    @RequestMapping("/vehicleMakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id) {
        return vehicleMakeService.findById(id);
    }


    //Add New VehicleMake
    @PostMapping (value = "vehicleMakes/addNew")
    @ResponseBody
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }


    @RequestMapping(value ="/vehicleMakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMakes";
    }


    @RequestMapping(value = "/vehicleMakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }

}
