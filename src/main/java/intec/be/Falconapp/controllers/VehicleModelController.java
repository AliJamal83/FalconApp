package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.Country;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.State;
import intec.be.Falconapp.models.VehicleModel;
import intec.be.Falconapp.services.StateService;
import intec.be.Falconapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;


    @GetMapping("/vehicleModels")
    public String findAll(Model model) {
        List<VehicleModel> listOfvehicleModels = vehicleModelService.getAllVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelService.getAllVehicleModels());
        return "VehicleModel";

    }


    // Add New vehicle model
    @PostMapping("/vehicleModels/addNew")
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";

    }

    @RequestMapping("vehicleModels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelService.findById(id);

    }


    // Update vehicle model
    @RequestMapping(value = "/vehicleModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }


    // Delete vehicle model
    @RequestMapping(value = "/vehicleModels", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/vehicleModel";
    }
}
