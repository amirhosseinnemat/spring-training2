package com.springboot.restsample.crudsample.controller;


import com.springboot.restsample.crudsample.entity.Employee;
import com.springboot.restsample.crudsample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    EmployeeService theEmployeeService;

    // inject employeeService with constructor
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        this.theEmployeeService = theEmployeeService;
    }


    // test
    @GetMapping("/test")
    public String test() {

        return "this is test from rest controller";
    }

    // get all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {

        return theEmployeeService.findAll();
    }


    //    GET / get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        Employee theEmployee = theEmployeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("employee not found - the id : " + employeeId);
        } else {
            return theEmployeeService.findById(employeeId);
        }
    }

    //    POST / insert an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        theEmployeeService.save(theEmployee);
        return theEmployee;
    }

    //    DELETE / delete an employee by id
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        // load employee
        Employee employee = theEmployeeService.findById(employeeId);

        // check for null
        if (employee == null) {
            throw new RuntimeException("the employee with id : " + employeeId + " not found.");
        } else {
            theEmployeeService.deleteById(employeeId);
        }
        return "the employee with id : " + employeeId + " deleted successfully";
    }



    // add mapping for update

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        theEmployeeService.save(theEmployee);

        return theEmployee;
    }












//        add mapping for update
//    @PutMapping("/Employees/{employeeId}")
//    public UpdateResponse updateEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
//
//        // check employee exist
//        Employee theEmployee = theEmployeeService.findById(employeeId);
//
//        // create update response object
//        UpdateResponse response;
//
//        if (theEmployee == null) {
//            response = new UpdateResponse(employee.getId(),
//                    employee.getFirstName(),
//                    employee.getLastName(),
//                    employee.getEmail(),
//                    "update process failed",
//                    HttpStatus.NOT_FOUND);
//        } else {
//
//            // update the employee
//            theEmployeeService.save(employee);
//
//            // create response message
//            response = new UpdateResponse(employee.getId(),
//                    employee.getFirstName(),
//                    employee.getLastName(),
//                    employee.getEmail(),
//                    "update process done",
//                    HttpStatus.OK);
//        }
//        // return response
//        return response;
//    }
}


