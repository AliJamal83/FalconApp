package intec.be.Falconapp.services;


import intec.be.Falconapp.models.VehicleMake;
import intec.be.Falconapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {


    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    //Get All Vehicle make --> will return list of vehicles
    public List<VehicleMake> getAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    //Get All Vehicle make By id
    public Optional<VehicleMake> findById(Integer id){
        return vehicleMakeRepository.findById(id);
    }

    //Delete VehicleMake
    public void delete(Integer id){
        vehicleMakeRepository.deleteById(id);
    }

    //Update VehicleMake
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }
}
