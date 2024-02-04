package com.ashish.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.demo.model.employee_details;
import com.ashish.demo.reposiotry.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<employee_details> getAllEmp(){
        return employeeRepository.findAll();
    }

    public List<employee_details> getbyrole(String category){
        return employeeRepository.findByCategory(category);
    }
}
