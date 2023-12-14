package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
