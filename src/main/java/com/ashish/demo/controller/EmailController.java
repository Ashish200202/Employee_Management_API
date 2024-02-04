package com.ashish.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.demo.model.employee_details;
import com.ashish.demo.reposiotry.EmployeeRepository;
import com.ashish.demo.service.EmailService;
import com.ashish.demo.util.EmailDetails;

@RestController
@RequestMapping("/admin")
public class EmailController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;
    
    @GetMapping("/triggeremail/{id}")
    public String sendemail(@PathVariable int id){
        Optional<employee_details> getEmp=employeeRepository.findById(id);
        if(getEmp.isPresent()){
            employee_details emailemployee=getEmp.get();
            EmailDetails emailDetails=new EmailDetails(emailemployee.getEmail(), "Salary Slip", "Congratulatons " +emailemployee.getEmp_name()+" your salary of amount "+emailemployee.getSalary()+" has been credited to your account..!");
            emailService.SendEmail(emailDetails);
            return "Email Sent ";
        }else{

            return "Email Not sent..! ";
        }
        
    }
}
