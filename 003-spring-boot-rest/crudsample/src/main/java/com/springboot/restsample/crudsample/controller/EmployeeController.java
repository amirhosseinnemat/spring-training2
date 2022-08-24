package com.springboot.restsample.crudsample.controller;

import com.springboot.restsample.crudsample.dao.EmployeeDAO;
import com.springboot.restsample.crudsample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private EmployeeDAO employeeDAO;

    // inject with constructor

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // test
    @GetMapping("/test")
    public String test() {
        return "this is test from rest controller";
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }


    // get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeeDAO.findById(employeeId);
    }
}


