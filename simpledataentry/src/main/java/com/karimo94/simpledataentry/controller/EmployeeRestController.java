package com.karimo94.simpledataentry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karimo94.simpledataentry.model.Employee;
import com.karimo94.simpledataentry.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeRestController {
    @Autowired
    EmployeeService empService;
    //used for backend postman testing
    @PostMapping("/employee/new")
    public Employee savEmployee(@Valid @RequestBody Employee emp) {
        return empService.saveEmployee(emp);
    }
    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }
}
