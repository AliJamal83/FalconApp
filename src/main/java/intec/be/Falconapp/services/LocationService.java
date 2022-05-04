package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {


    @Autowired
    private LocationRepository locationRepository;

    //Get All Locations
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    // Get location By id
    public Optional<Location> findById(Integer id) {
        return locationRepository.findById(id);
    }

    // Save New Location
    public void save(Location location) {
        locationRepository.save(location);
    }


    // Delete Location
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }


}
