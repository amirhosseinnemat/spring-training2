package com.springboot.restsample.crudsample.service;



import com.springboot.restsample.crudsample.entity.Employee;
import com.springboot.restsample.crudsample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // get all employee
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    // get one employee by id
    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if (result.isPresent())
            employee = result.get();
        else
            throw new RuntimeException("not found");
        return employee;
    }

    // save employee
    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    // delete an employee by id
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
