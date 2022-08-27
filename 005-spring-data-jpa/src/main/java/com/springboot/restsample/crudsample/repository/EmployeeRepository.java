package com.springboot.restsample.crudsample.repository;

import com.springboot.restsample.crudsample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
