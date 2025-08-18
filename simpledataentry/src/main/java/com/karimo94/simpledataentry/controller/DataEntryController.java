package com.karimo94.simpledataentry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.karimo94.simpledataentry.model.Employee;
import com.karimo94.simpledataentry.service.EmployeeService;
import jakarta.validation.Valid;


@Controller
public class DataEntryController {

    @Autowired
    EmployeeService empService;
    
    @GetMapping("/")
    public String entryForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/employee/submit")
    public String entrySubmit(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "index";
        }
        else {
            model.addAttribute("employee", employee);
            empService.saveEmployee(employee);
            model.addAttribute("employees", empService.getAllEmployees());
            return "result";
        }
    }
    

    @GetMapping("/employee/test")
    public Employee getTestEmployee() {
        return new Employee("Test User", 35, "Firmware Engineer", "New York, NY");
    }
}
