package com.karimo94.simpledataentry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karimo94.simpledataentry.model.Employee;
import com.karimo94.simpledataentry.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeService() {}

    public Employee saveEmployee(Employee data) {
        return employeeRepo.save(data);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
