package com.ashish.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ashish.demo.model.employee_details;
import com.ashish.demo.service.EmployeeService;

@RestController
@RequestMapping("/home")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/AllEmp")
    public List<employee_details> getAllEmp(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/role/{category}")
    public List<employee_details> getbyrole(@PathVariable String category){
        return employeeService.getbyrole(category);
    }
}
