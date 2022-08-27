package com.springboot.restsample.crudsample.service;


import com.springboot.restsample.crudsample.dao.EmployeeDAO;
import com.springboot.restsample.crudsample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }


    // get all employee
    @Override
    @Transactional
    public List<Employee> findAll() {

        return employeeDAO.findAll();
    }

    // get one employee by id
    @Override
    @Transactional
    public Employee findById(int theId) {

        return employeeDAO.findById(theId);
    }

    // save employee
    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }

    // delete an employee by id
    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
