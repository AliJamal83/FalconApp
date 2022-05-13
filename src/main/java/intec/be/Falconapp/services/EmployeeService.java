package intec.be.Falconapp.services;


import intec.be.Falconapp.models.Employee;
import intec.be.Falconapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    //Get All Employees
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //Get Employee by id
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    //Delete Employee
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    //Update Employee
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    //Get Employee by username
    public Employee findByUsername(String userName) {
        return employeeRepository.findByUsername(userName);
    }
}
