package com.springboot.restsample.crudsample.service;

import com.springboot.restsample.crudsample.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int Id);

}
