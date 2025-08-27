package com.karimo94.simpledataentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karimo94.simpledataentry.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
    //custom query methods definitions here if need be
}
