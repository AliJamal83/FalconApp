package intec.be.Falconapp.controllers;


import intec.be.Falconapp.models.VehicleStatus;
import intec.be.Falconapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;


    @GetMapping("/vehicleStatus")
    public String findAll(Model model) {
        List<VehicleStatus> listOfVehicleStatus = vehicleStatusService.findAll();
        model.addAttribute("vehicleStatus", vehicleStatusService.findAll());
        return "VehicleStatus";

    }


    // Add New vehicle status
    @PostMapping("/vehicleStatus/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";

    }

    @RequestMapping("vehicleStatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusService.findById(id);

    }


    // Update vehicle status
    @RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    private String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }


    // Delete vehicle status
    @RequestMapping(value = "/vehicleStatus", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }
}
