package com.springboot.restsample.crudsample.dao;

import com.springboot.restsample.crudsample.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
