package intec.be.Falconapp.services;


import intec.be.Falconapp.models.EmployeeType;
import intec.be.Falconapp.models.Location;
import intec.be.Falconapp.repositories.EmployeeTypeRepository;
import intec.be.Falconapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {


    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    //Return list of countries
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    //SAve new EmployeeType
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    //get by id
    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }

}
