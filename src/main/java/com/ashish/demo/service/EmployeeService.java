package com.ashish.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ashish.demo.model.employee_details;
import com.ashish.demo.reposiotry.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<employee_details>> getAllEmp(){
        try{
            return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<employee_details> getbyrole(String category){
        return employeeRepository.findByCategory(category);
    }

    @SuppressWarnings("null")
    public ResponseEntity<String> AddEmployee(employee_details details){
        try{
        employeeRepository.save(details);
        return new ResponseEntity<>("Employee Created Successfullty", HttpStatus.CREATED) ;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("EMPLOYEE CREATION FAILED", HttpStatus.BAD_REQUEST);
    }
}
