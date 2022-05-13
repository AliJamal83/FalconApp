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

    //Get All EmployeeTypes
    public List<EmployeeType> findAll() {
        return employeeTypeRepository.findAll();
    }

    //Get EmployeeType By Id
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    //Delete EmployeeType
    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }

    //Update EmployeeType
    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

}
