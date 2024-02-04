package com.ashish.demo.reposiotry;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.demo.model.employee_details;
//A Repo will always be a interface with will extend JpaRepo
//<What type of table,primary key>
@Repository
public interface EmployeeRepository extends JpaRepository<employee_details,Integer>{

    List<employee_details> findByCategory(String category);
    
} 