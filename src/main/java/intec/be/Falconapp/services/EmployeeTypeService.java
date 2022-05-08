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

    //Get All employees --> this method will return a list of countries
    public List<EmployeeType> getAllEmployees() {
        return employeeTypeRepository.findAll();
    }

    // Get employee By id
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    // Save New Employee
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }


    // Delete employee
    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
