package intec.be.Falconapp.services;


import intec.be.Falconapp.models.VehicleModel;
import intec.be.Falconapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {


    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Get All vehicle models --> this method will return a list of vehicle models
    public List<VehicleModel> findAll() {
        return vehicleModelRepository.findAll();
    }

    // Get vehicle model By id
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    // Save New vehicle model
    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }


    // Delete vehicle model
    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
