package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.Vehicle;
import intec.be.Falconapp.repositories.LocationRepository;
import intec.be.Falconapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {


    @Autowired
    private VehicleRepository vehicleRepository;

    //Get All vehicles --> this method will return a list of countries
    public List<Vehicle> getAllVehicleService() {
        return vehicleRepository.findAll();
    }

    // Get vehicle By id
    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }

    // Save New vehicle
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }


    // Delete vehicle
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }


}
