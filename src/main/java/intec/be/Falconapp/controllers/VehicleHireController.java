package intec.be.Falconapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {

    @Autowired


    @GetMapping("/vehiclesHire")
    public String getVehicleHire() {
        return "VehicleHire";

    }
}
