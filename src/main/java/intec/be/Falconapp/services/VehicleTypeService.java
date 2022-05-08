package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.VehicleType;
import intec.be.Falconapp.repositories.LocationRepository;
import intec.be.Falconapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    //Get All vehicle types --> this method will return a list of countries
    public List<VehicleType> getAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    // Get vehicle type By id
    public Optional<VehicleType> findById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }

    // Save New vehicle types
    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }


    // Delete vehicle type
    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
