package com.springboot.restsample.crudsample.dao;

import com.springboot.restsample.crudsample.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

}
