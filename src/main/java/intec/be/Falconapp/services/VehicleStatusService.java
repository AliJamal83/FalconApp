package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.models.VehicleStatus;
import intec.be.Falconapp.repositories.LocationRepository;
import intec.be.Falconapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Get All vehicle status --> this method will return a list of countries
    public List<VehicleStatus> getAllVehiclesStatus() {
        return vehicleStatusRepository.findAll();
    }

    // Get vehicle status By id
    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    // Save New vehicle status
    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }


    // Delete vehicle status
    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
